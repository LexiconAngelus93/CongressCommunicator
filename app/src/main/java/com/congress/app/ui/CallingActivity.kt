package com.congress.app.ui

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.congress.app.R
import com.congress.app.calling.CallService
import com.congress.app.databinding.ActivityCallingBinding
import com.congress.app.ui.adapters.CallLogAdapter
import kotlinx.coroutines.launch

class CallingActivity : AppCompatActivity() {
    
    companion object {
        private const val CALL_PERMISSION_REQUEST = 1001
        private const val AUDIO_PERMISSION_REQUEST = 1002
    }
    
    private lateinit var binding: ActivityCallingBinding
    private lateinit var callService: CallService
    private lateinit var callLogAdapter: CallLogAdapter
    private var selectedPhoneNumbers = mutableListOf<String>()
    private var isBatchMode = false
    private var isCallInProgress = false
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCallingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        callService = CallService(this)
        isBatchMode = intent.getBooleanExtra("batch_mode", false)
        
        setupToolbar()
        setupRecyclerView()
        setupClickListeners()
        setupCallStateObserver()
        checkPermissions()
        
        // If not batch mode, get specific member
        if (!isBatchMode) {
            val memberId = intent.getIntExtra("member_id", -1)
            if (memberId != -1) {
                loadMemberPhone(memberId)
            }
        }
        
        // Initialize call service
        lifecycleScope.launch {
            val initialized = callService.initialize()
            if (!initialized) {
                Toast.makeText(this@CallingActivity, "Failed to initialize calling service", Toast.LENGTH_LONG).show()
            }
        }
    }
    
    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = if (isBatchMode) "Batch Calling" else "Make Call"
    }
    
    private fun setupRecyclerView() {
        callLogAdapter = CallLogAdapter()
        binding.callLogRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.callLogRecyclerView.adapter = callLogAdapter
    }
    
    private fun setupClickListeners() {
        binding.btnSelectRecipients.setOnClickListener {
            showRecipientSelectionDialog()
        }
        
        binding.btnSelectAllCalls.setOnClickListener {
            selectAllMembers()
        }
        
        binding.btnStartCalls.setOnClickListener {
            startCalls()
        }
        
        binding.btnStopCalls.setOnClickListener {
            stopCalls()
        }
        
        binding.btnTestTTS.setOnClickListener {
            testTTS()
        }
        
        binding.btnStopTTS.setOnClickListener {
            callService.stopSpeaking()
        }
        
        binding.useTTSSwitch.setOnCheckedChangeListener { _, isChecked ->
            binding.ttsControlsLayout.visibility = if (isChecked) View.VISIBLE else View.GONE
        }
        
        // Set default script
        binding.callScriptEditText.setText(getDefaultScript())
    }
    
    private fun setupCallStateObserver() {
        lifecycleScope.launch {
            callService.callState.collect { state ->
                updateCallStatus(state)
            }
        }
    }
    
    private fun updateCallStatus(state: CallService.CallState) {
        val statusText = when (state) {
            CallService.CallState.IDLE -> "Ready to call"
            CallService.CallState.DIALING -> "Dialing..."
            CallService.CallState.RINGING -> "Ringing..."
            CallService.CallState.CONNECTED -> "Connected"
            CallService.CallState.SPEAKING -> "Speaking script..."
            CallService.CallState.NAVIGATING_MENU -> "Navigating phone menu..."
            CallService.CallState.COMPLETED -> "Call completed"
            CallService.CallState.FAILED -> "Call failed"
        }
        
        binding.callStatusText.text = statusText
        
        // Update UI based on state
        isCallInProgress = state != CallService.CallState.IDLE && 
                          state != CallService.CallState.COMPLETED && 
                          state != CallService.CallState.FAILED
        
        binding.btnStartCalls.isEnabled = !isCallInProgress && selectedPhoneNumbers.isNotEmpty()
        binding.btnStopCalls.isEnabled = isCallInProgress
    }
    
    private fun checkPermissions() {
        val permissions = mutableListOf<String>()
        
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) 
            != PackageManager.PERMISSION_GRANTED) {
            permissions.add(Manifest.permission.CALL_PHONE)
        }
        
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) 
            != PackageManager.PERMISSION_GRANTED) {
            permissions.add(Manifest.permission.RECORD_AUDIO)
        }
        
        if (permissions.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, permissions.toTypedArray(), CALL_PERMISSION_REQUEST)
        }
    }
    
    private fun loadMemberPhone(memberId: Int) {
        // TODO: Load specific member's phone from database
        // For now, add placeholder
        selectedPhoneNumbers.add("(202) 225-4965")
        updateRecipientCount()
    }
    
    private fun showRecipientSelectionDialog() {
        // TODO: Implement recipient selection dialog
        // For now, add sample phone numbers
        selectedPhoneNumbers.addAll(listOf(
            "(202) 225-4965",
            "(202) 224-6542"
        ))
        updateRecipientCount()
    }
    
    private fun selectAllMembers() {
        // TODO: Load all Congress members' phones from database
        // For now, add sample phone numbers
        selectedPhoneNumbers.clear()
        selectedPhoneNumbers.addAll(listOf(
            "(202) 225-4965",
            "(202) 224-6542",
            "(202) 224-2541",
            "(202) 225-2676"
        ))
        updateRecipientCount()
    }
    
    private fun updateRecipientCount() {
        binding.recipientCountText.text = "${selectedPhoneNumbers.size} recipients selected"
    }
    
    private fun startCalls() {
        if (selectedPhoneNumbers.isEmpty()) {
            Toast.makeText(this, "Please select recipients", Toast.LENGTH_SHORT).show()
            return
        }
        
        val script = binding.callScriptEditText.text.toString().trim()
        val callerIdAlias = binding.callerIdEditText.text.toString().trim()
        val useTTS = binding.useTTSSwitch.isChecked
        val useAutoNavigation = binding.autoNavigateSwitch.isChecked
        
        showProgress(true)
        
        lifecycleScope.launch {
            try {
                val config = CallService.CallConfig(
                    phoneNumber = "", // Will be set for each call
                    callerIdAlias = callerIdAlias.ifEmpty { null },
                    script = script,
                    useAutoNavigation = useAutoNavigation,
                    useTTS = useTTS,
                    menuNavigationRules = callService.getCongressMenuRules()
                )
                
                if (selectedPhoneNumbers.size == 1) {
                    // Single call
                    val result = callService.makeCall(config.copy(phoneNumber = selectedPhoneNumbers[0]))
                    handleCallResult(result, selectedPhoneNumbers[0])
                } else {
                    // Batch calls
                    val results = callService.makeBatchCalls(selectedPhoneNumbers, config)
                    handleBatchResults(results)
                }
                
            } catch (e: Exception) {
                Toast.makeText(this@CallingActivity, "Error: ${e.message}", Toast.LENGTH_LONG).show()
            } finally {
                showProgress(false)
            }
        }
    }
    
    private fun stopCalls() {
        callService.endCall()
        callService.stopSpeaking()
        showProgress(false)
    }
    
    private fun testTTS() {
        val script = binding.callScriptEditText.text.toString().trim()
        if (script.isEmpty()) {
            Toast.makeText(this, "Please enter a script to test", Toast.LENGTH_SHORT).show()
            return
        }
        
        lifecycleScope.launch {
            callService.stopSpeaking() // Stop any current speech
            // Note: TTS testing would require access to TTSService directly
            Toast.makeText(this@CallingActivity, "TTS test started", Toast.LENGTH_SHORT).show()
        }
    }
    
    private fun handleCallResult(result: CallService.CallResult, phoneNumber: String) {
        val logEntry = CallLogAdapter.CallLogEntry(
            phoneNumber = phoneNumber,
            status = if (result.success) "Success" else "Failed",
            message = result.message,
            timestamp = System.currentTimeMillis()
        )
        
        callLogAdapter.addLogEntry(logEntry)
        binding.callLogCard.visibility = View.VISIBLE
        
        val message = if (result.success) "Call completed successfully" else "Call failed: ${result.message}"
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
    
    private fun handleBatchResults(results: List<CallService.CallResult>) {
        results.forEachIndexed { index, result ->
            val phoneNumber = selectedPhoneNumbers.getOrNull(index) ?: "Unknown"
            handleCallResult(result, phoneNumber)
        }
        
        val successCount = results.count { it.success }
        val totalCount = results.size
        
        Toast.makeText(
            this,
            "Batch calling completed: $successCount/$totalCount successful",
            Toast.LENGTH_LONG
        ).show()
    }
    
    private fun showProgress(show: Boolean) {
        binding.progressLayout.visibility = if (show) View.VISIBLE else View.GONE
        binding.btnStartCalls.isEnabled = !show && selectedPhoneNumbers.isNotEmpty()
    }
    
    private fun getDefaultScript(): String {
        return callService.createCongressScript(
            memberName = "[Member Name]",
            issue = "[Your Issue]",
            position = "[Your Position]",
            callerName = "[Your Name]",
            callerLocation = "[Your Location]"
        )
    }
    
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        
        when (requestCode) {
            CALL_PERMISSION_REQUEST -> {
                val allGranted = grantResults.all { it == PackageManager.PERMISSION_GRANTED }
                if (!allGranted) {
                    Toast.makeText(this, "Call permissions are required for this feature", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    
    override fun onDestroy() {
        super.onDestroy()
        callService.shutdown()
    }
}

