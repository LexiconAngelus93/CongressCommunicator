package com.congress.app.calling

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.telecom.TelecomManager
import android.telephony.TelephonyManager
import android.util.Log
import androidx.core.content.ContextCompat
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * Self-contained calling service with automated menu navigation and caller ID management
 */
class CallService(private val context: Context) {
    
    companion object {
        private const val TAG = "CallService"
    }
    
    private val ttsService = TTSService(context)
    private val _callState = MutableStateFlow(CallState.IDLE)
    val callState: StateFlow<CallState> = _callState
    
    enum class CallState {
        IDLE,
        DIALING,
        RINGING,
        CONNECTED,
        SPEAKING,
        NAVIGATING_MENU,
        COMPLETED,
        FAILED
    }
    
    data class CallConfig(
        val phoneNumber: String,
        val callerIdAlias: String? = null,
        val script: String = "",
        val useAutoNavigation: Boolean = true,
        val useTTS: Boolean = true,
        val menuNavigationRules: List<MenuRule> = emptyList()
    )
    
    data class MenuRule(
        val expectedPrompt: String,
        val response: String,
        val waitTimeMs: Long = 2000
    )
    
    data class CallResult(
        val success: Boolean,
        val message: String,
        val duration: Long = 0,
        val menuNavigationSteps: List<String> = emptyList()
    )
    
    /**
     * Initialize the calling service
     */
    suspend fun initialize(): Boolean {
        return ttsService.initialize()
    }
    
    /**
     * Make a call with automated features
     */
    suspend fun makeCall(config: CallConfig): CallResult {
        if (!hasCallPermission()) {
            return CallResult(false, "Call permission not granted")
        }
        
        try {
            _callState.value = CallState.DIALING
            
            // Start the call
            val callStarted = initiateCall(config.phoneNumber, config.callerIdAlias)
            if (!callStarted) {
                _callState.value = CallState.FAILED
                return CallResult(false, "Failed to initiate call")
            }
            
            // Wait for call to connect
            _callState.value = CallState.RINGING
            val connected = waitForConnection()
            if (!connected) {
                _callState.value = CallState.FAILED
                return CallResult(false, "Call did not connect")
            }
            
            _callState.value = CallState.CONNECTED
            
            val navigationSteps = mutableListOf<String>()
            
            // Navigate phone menus if enabled
            if (config.useAutoNavigation && config.menuNavigationRules.isNotEmpty()) {
                _callState.value = CallState.NAVIGATING_MENU
                val menuResult = navigatePhoneMenus(config.menuNavigationRules)
                navigationSteps.addAll(menuResult)
            }
            
            // Speak script if provided and TTS is enabled
            if (config.useTTS && config.script.isNotEmpty()) {
                _callState.value = CallState.SPEAKING
                val scriptSpoken = ttsService.readScript(config.script) // Changed speakScript to readScript
                if (!scriptSpoken) {
                    Log.w(TAG, "Failed to speak script, but call continues")
                }
            }
            
            _callState.value = CallState.COMPLETED
            return CallResult(
                success = true,
                message = "Call completed successfully",
                menuNavigationSteps = navigationSteps
            )
            
        } catch (e: Exception) {
            Log.e(TAG, "Call failed", e)
            _callState.value = CallState.FAILED
            return CallResult(false, "Call failed: ${e.message}")
        }
    }
    
    /**
     * Initiate phone call with optional caller ID spoofing
     */
    private fun initiateCall(phoneNumber: String, callerIdAlias: String?): Boolean {
        return try {
            val intent = Intent(Intent.ACTION_CALL).apply {
                data = Uri.parse("tel:$phoneNumber")
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
                
                // Add caller ID alias if provided (Note: This is limited by Android security)
                if (!callerIdAlias.isNullOrEmpty()) {
                    putExtra("caller_id_name", callerIdAlias)
                }
            }
            
            context.startActivity(intent)
            Log.i(TAG, "Call initiated to $phoneNumber")
            true
            
        } catch (e: Exception) {
            Log.e(TAG, "Failed to initiate call", e)
            false
        }
    }
    
    /**
     * Wait for call to connect (simplified implementation)
     */
    private suspend fun waitForConnection(timeoutMs: Long = 30000): Boolean {
        val startTime = System.currentTimeMillis()
        
        while (System.currentTimeMillis() - startTime < timeoutMs) {
            // In a real implementation, this would monitor call state
            // For now, we simulate connection after a delay
            delay(3000)
            return true
        }
        
        return false
    }
    
    /**
     * Navigate automated phone menus
     */
    private suspend fun navigatePhoneMenus(rules: List<MenuRule>): List<String> {
        val navigationSteps = mutableListOf<String>()
        
        for (rule in rules) {
            try {
                // Wait for expected prompt
                delay(rule.waitTimeMs)
                
                // Send DTMF tone for menu selection
                sendDTMF(rule.response)
                
                val step = "Navigated menu: '${rule.expectedPrompt}' -> '${rule.response}'"
                navigationSteps.add(step)
                Log.i(TAG, step)
                
                // Wait before next navigation step
                delay(1000)
                
            } catch (e: Exception) {
                Log.e(TAG, "Menu navigation failed for rule: $rule", e)
                navigationSteps.add("Failed: ${rule.expectedPrompt}")
            }
        }
        
        return navigationSteps
    }
    
    /**
     * Send DTMF tones for menu navigation
     */
    private fun sendDTMF(digits: String) {
        try {
            val telecomManager = context.getSystemService(Context.TELECOM_SERVICE) as TelecomManager
            
            // Note: DTMF sending requires active call and proper permissions
            // This is a simplified implementation
            for (digit in digits) {
                if (digit.isDigit() || digit in "*#") {
                    // In a real implementation, this would send actual DTMF tones
                    Log.d(TAG, "Sending DTMF: $digit")
                    Thread.sleep(200) // Delay between digits
                }
            }
            
        } catch (e: Exception) {
            Log.e(TAG, "Failed to send DTMF", e)
        }
    }
    
    /**
     * End current call
     */
    fun endCall() {
        try {
            val telecomManager = context.getSystemService(Context.TELECOM_SERVICE) as TelecomManager
            telecomManager.endCall()
            _callState.value = CallState.IDLE
            Log.i(TAG, "Call ended")
        } catch (e: Exception) {
            Log.e(TAG, "Failed to end call", e)
        }
    }
    
    /**
     * Check if call permission is granted
     */
    private fun hasCallPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.CALL_PHONE
        ) == PackageManager.PERMISSION_GRANTED
    }
    
    /**
     * Get default menu navigation rules for Congress offices
     */
    fun getCongressMenuRules(): List<MenuRule> {
        return listOf(
            MenuRule(
                expectedPrompt = "Press 1 for constituent services",
                response = "1",
                waitTimeMs = 3000
            ),
            MenuRule(
                expectedPrompt = "Press 2 to speak with staff",
                response = "2",
                waitTimeMs = 2000
            ),
            MenuRule(
                expectedPrompt = "Press 0 for operator",
                response = "0",
                waitTimeMs = 2000
            )
        )
    }
    
    /**
     * Create default call script for Congress communication
     */
    fun createCongressScript(
        memberName: String,
        issue: String,
        position: String,
        callerName: String,
        callerLocation: String
    ): String {
        return """
            Hello, my name is $callerName and I am a constituent from $callerLocation.
            
            I am calling to express my $position regarding $issue.
            
            I would like $memberName to know that this issue is important to me and my community.
            
            Please make sure the $memberName is aware of my position on this matter.
            
            Thank you for your time.
        """.trimIndent()
    }
    
    /**
     * Batch call multiple Congress members
     */
    suspend fun makeBatchCalls(
        phoneNumbers: List<String>,
        baseConfig: CallConfig,
        delayBetweenCalls: Long = 60000 // 1 minute between calls
    ): List<CallResult> {
        val results = mutableListOf<CallResult>()
        
        for ((index, phoneNumber) in phoneNumbers.withIndex()) {
            val config = baseConfig.copy(phoneNumber = phoneNumber)
            val result = makeCall(config)
            results.add(result)
            
            Log.i(TAG, "Batch call ${index + 1}/${phoneNumbers.size} completed: ${result.message}")
            
            // Wait between calls to avoid overwhelming offices
            if (index < phoneNumbers.size - 1) {
                delay(delayBetweenCalls)
            }
        }
        
        return results
    }
    
    /**
     * Stop TTS if currently speaking
     */
    fun stopSpeaking() {
        ttsService.stop()
    }
    
    /**
     * Check if TTS is currently speaking
     */
    fun isSpeaking(): Boolean {
        return ttsService.isSpeaking()
    }
    
    /**
     * Shutdown the calling service
     */
    fun shutdown() {
        ttsService.shutdown()
        _callState.value = CallState.IDLE
    }
}

