package com.congress.app.ui

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.congress.app.R
import com.congress.app.databinding.ActivityEmailComposerBinding
import com.congress.app.email.EmailManager
import com.congress.app.email.EmailService
import kotlinx.coroutines.launch

class EmailComposerActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityEmailComposerBinding
    private lateinit var emailManager: EmailManager
    private var selectedRecipients = mutableListOf<String>()
    private var isBatchMode = false
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailComposerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        emailManager = EmailManager(this)
        isBatchMode = intent.getBooleanExtra("batch_mode", false)
        
        setupToolbar()
        setupEmailAccounts()
        setupTemplates()
        setupClickListeners()
        
        // If not batch mode, get specific member
        if (!isBatchMode) {
            val memberId = intent.getIntExtra("member_id", -1)
            if (memberId != -1) {
                // Load specific member email
                loadMemberEmail(memberId)
            }
        }
    }
    
    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = if (isBatchMode) "Batch Email" else "Compose Email"
    }
    
    private fun setupEmailAccounts() {
        val accounts = emailManager.getEmailAccounts()
        val accountDisplays = accounts.map { "${it.displayName.ifEmpty { it.email }} <${it.email}>" }
        
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, accountDisplays)
        binding.emailAccountSpinner.setAdapter(adapter)
        
        // Set default account if available
        val defaultAccount = emailManager.getDefaultAccount()
        if (defaultAccount != null) {
            val defaultIndex = accounts.indexOfFirst { it.email == defaultAccount.email }
            if (defaultIndex >= 0) {
                binding.emailAccountSpinner.setText(accountDisplays[defaultIndex], false)
            }
        }
        
        if (accounts.isEmpty()) {
            Toast.makeText(this, "Please add an email account in settings first", Toast.LENGTH_LONG).show()
        }
    }
    
    private fun setupTemplates() {
        val templates = emailManager.getEmailTemplates()
        val templateNames = listOf("Custom") + templates.map { it.name }
        
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, templateNames)
        binding.templateSpinner.setAdapter(adapter)
        
        binding.templateSpinner.setOnItemClickListener { _, _, position, _ ->
            if (position > 0) { // Not "Custom"
                val template = templates[position - 1]
                binding.subjectEditText.setText(template.subject)
                binding.messageEditText.setText(template.body)
                binding.htmlSwitch.isChecked = template.isHtml
            }
        }
    }
    
    private fun setupClickListeners() {
        binding.btnSelectRecipients.setOnClickListener {
            // TODO: Open recipient selection dialog
            showRecipientSelectionDialog()
        }
        
        binding.btnSelectAll.setOnClickListener {
            // TODO: Select all Congress members
            selectAllMembers()
        }
        
        binding.btnSaveDraft.setOnClickListener {
            saveDraft()
        }
        
        binding.btnSendEmail.setOnClickListener {
            sendEmail()
        }
    }
    
    private fun loadMemberEmail(memberId: Int) {
        // TODO: Load specific member's email from database
        // For now, add placeholder
        selectedRecipients.add("member@congress.gov")
        updateRecipientCount()
    }
    
    private fun showRecipientSelectionDialog() {
        // TODO: Implement recipient selection dialog
        // For now, add sample recipients
        selectedRecipients.addAll(listOf(
            "pelosi@house.gov",
            "schumer@senate.gov"
        ))
        updateRecipientCount()
    }
    
    private fun selectAllMembers() {
        // TODO: Load all Congress members from database
        // For now, add sample recipients
        selectedRecipients.clear()
        selectedRecipients.addAll(listOf(
            "pelosi@house.gov",
            "schumer@senate.gov",
            "mcconnell@senate.gov",
            "jordan@house.gov"
        ))
        updateRecipientCount()
    }
    
    private fun updateRecipientCount() {
        binding.recipientCountText.text = "${selectedRecipients.size} recipients selected"
    }
    
    private fun saveDraft() {
        // TODO: Implement draft saving
        Toast.makeText(this, "Draft saved", Toast.LENGTH_SHORT).show()
    }
    
    private fun sendEmail() {
        if (selectedRecipients.isEmpty()) {
            Toast.makeText(this, "Please select recipients", Toast.LENGTH_SHORT).show()
            return
        }
        
        val subject = binding.subjectEditText.text.toString().trim()
        if (subject.isEmpty()) {
            Toast.makeText(this, "Please enter a subject", Toast.LENGTH_SHORT).show()
            return
        }
        
        val message = binding.messageEditText.text.toString().trim()
        if (message.isEmpty()) {
            Toast.makeText(this, "Please enter a message", Toast.LENGTH_SHORT).show()
            return
        }
        
        val selectedAccountText = binding.emailAccountSpinner.text.toString()
        if (selectedAccountText.isEmpty()) {
            Toast.makeText(this, "Please select an email account", Toast.LENGTH_SHORT).show()
            return
        }
        
        // Extract email from display text
        val accountEmail = selectedAccountText.substringAfter("<").substringBefore(">")
        
        showProgress(true)
        
        lifecycleScope.launch {
            try {
                val emailMessage = EmailService.EmailMessage(
                    to = selectedRecipients,
                    subject = subject,
                    body = message,
                    isHtml = binding.htmlSwitch.isChecked
                )
                
                val result = if (selectedRecipients.size == 1) {
                    emailManager.sendEmail(accountEmail, emailMessage)
                } else {
                    // For batch sending, create individual messages
                    val messages = selectedRecipients.map { recipient ->
                        emailMessage.copy(to = listOf(recipient))
                    }
                    emailManager.sendBatchEmails(accountEmail, messages)
                }
                
                showProgress(false)
                
                if (result.success) {
                    Toast.makeText(this@EmailComposerActivity, result.message, Toast.LENGTH_LONG).show()
                    finish()
                } else {
                    Toast.makeText(this@EmailComposerActivity, "Failed: ${result.message}", Toast.LENGTH_LONG).show()
                }
                
            } catch (e: Exception) {
                showProgress(false)
                Toast.makeText(this@EmailComposerActivity, "Error: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
    
    private fun showProgress(show: Boolean) {
        binding.progressIndicator.visibility = if (show) View.VISIBLE else View.GONE
        binding.progressText.visibility = if (show) View.VISIBLE else View.GONE
        binding.btnSendEmail.isEnabled = !show
        binding.btnSaveDraft.isEnabled = !show
    }
    
    @Suppress("DEPRECATION")
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

