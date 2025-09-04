package com.congress.app.email

import android.content.Context
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*
import javax.mail.*
import javax.mail.internet.*

/**
 * Self-contained email service with embedded SMTP functionality
 * Supports email aliases and batch sending without external configuration
 */
class EmailService(private val context: Context) {
    
    companion object {
        private const val TAG = "EmailService"
        
        // Built-in SMTP configurations for popular email providers
        private val SMTP_CONFIGS = mapOf(
            "gmail.com" to SMTPConfig("smtp.gmail.com", 587, true),
            "outlook.com" to SMTPConfig("smtp-mail.outlook.com", 587, true),
            "hotmail.com" to SMTPConfig("smtp-mail.outlook.com", 587, true),
            "yahoo.com" to SMTPConfig("smtp.mail.yahoo.com", 587, true),
            "aol.com" to SMTPConfig("smtp.aol.com", 587, true),
            "icloud.com" to SMTPConfig("smtp.mail.me.com", 587, true)
        )
    }
    
    data class SMTPConfig(
        val host: String,
        val port: Int,
        val useTLS: Boolean
    )
    
    data class EmailAccount(
        val email: String,
        val password: String,
        val displayName: String = "",
        val alias: String = ""
    )
    
    data class EmailMessage(
        val to: List<String>,
        val subject: String,
        val body: String,
        val isHtml: Boolean = false
    )
    
    data class EmailResult(
        val success: Boolean,
        val message: String,
        val sentCount: Int = 0,
        val failedCount: Int = 0
    )
    
    /**
     * Send email using built-in SMTP with automatic configuration
     */
    suspend fun sendEmail(
        account: EmailAccount,
        message: EmailMessage
    ): EmailResult = withContext(Dispatchers.IO) {
        try {
            val domain = account.email.substringAfter("@").lowercase()
            val smtpConfig = SMTP_CONFIGS[domain]
                ?: return@withContext EmailResult(false, "Unsupported email provider: $domain")
            
            val session = createSession(smtpConfig, account)
            val mimeMessage = createMimeMessage(session, account, message)
            
            Transport.send(mimeMessage)
            
            Log.i(TAG, "Email sent successfully to ${message.to.size} recipients")
            EmailResult(true, "Email sent successfully", message.to.size, 0)
            
        } catch (e: Exception) {
            Log.e(TAG, "Failed to send email", e)
            EmailResult(false, "Failed to send email: ${e.message}", 0, message.to.size)
        }
    }
    
    /**
     * Send batch emails to multiple recipients
     */
    suspend fun sendBatchEmails(
        account: EmailAccount,
        messages: List<EmailMessage>
    ): EmailResult = withContext(Dispatchers.IO) {
        var successCount = 0
        var failureCount = 0
        val errors = mutableListOf<String>()
        
        try {
            val domain = account.email.substringAfter("@").lowercase()
            val smtpConfig = SMTP_CONFIGS[domain]
                ?: return@withContext EmailResult(false, "Unsupported email provider: $domain")
            
            val session = createSession(smtpConfig, account)
            
            messages.forEach { message ->
                try {
                    val mimeMessage = createMimeMessage(session, account, message)
                    Transport.send(mimeMessage)
                    successCount += message.to.size
                    Log.i(TAG, "Batch email sent to ${message.to.size} recipients")
                } catch (e: Exception) {
                    failureCount += message.to.size
                    errors.add("Failed to send to ${message.to}: ${e.message}")
                    Log.e(TAG, "Failed to send batch email", e)
                }
            }
            
            val resultMessage = if (errors.isEmpty()) {
                "All emails sent successfully"
            } else {
                "Sent $successCount emails, failed $failureCount. Errors: ${errors.joinToString("; ")}"
            }
            
            EmailResult(errors.isEmpty(), resultMessage, successCount, failureCount)
            
        } catch (e: Exception) {
            Log.e(TAG, "Failed to send batch emails", e)
            EmailResult(false, "Batch email failed: ${e.message}", successCount, failureCount)
        }
    }
    
    /**
     * Create SMTP session with authentication
     */
    private fun createSession(config: SMTPConfig, account: EmailAccount): Session {
        val props = Properties().apply {
            put("mail.smtp.host", config.host)
            put("mail.smtp.port", config.port.toString())
            put("mail.smtp.auth", "true")
            
            if (config.useTLS) {
                put("mail.smtp.starttls.enable", "true")
                put("mail.smtp.starttls.required", "true")
            }
            
            // Security settings
            put("mail.smtp.ssl.protocols", "TLSv1.2")
            put("mail.smtp.ssl.trust", config.host)
        }
        
        return Session.getInstance(props, object : Authenticator() {
            override fun getPasswordAuthentication(): PasswordAuthentication {
                return PasswordAuthentication(account.email, account.password)
            }
        })
    }
    
    /**
     * Create MIME message with proper headers and alias support
     */
    private fun createMimeMessage(
        session: Session,
        account: EmailAccount,
        message: EmailMessage
    ): MimeMessage {
        val mimeMessage = MimeMessage(session)
        
        // Set sender with alias support
        val fromAddress = if (account.alias.isNotEmpty()) {
            InternetAddress(account.email, account.alias)
        } else if (account.displayName.isNotEmpty()) {
            InternetAddress(account.email, account.displayName)
        } else {
            InternetAddress(account.email)
        }
        mimeMessage.setFrom(fromAddress)
        
        // Set recipients
        val recipients = message.to.map { InternetAddress(it) }.toTypedArray()
        mimeMessage.setRecipients(Message.RecipientType.TO, recipients)
        
        // Set subject and body
        mimeMessage.subject = message.subject
        
        if (message.isHtml) {
            mimeMessage.setContent(message.body, "text/html; charset=utf-8")
        } else {
            mimeMessage.setText(message.body, "utf-8")
        }
        
        // Set headers
        mimeMessage.setHeader("X-Mailer", "Congress Communicator App")
        mimeMessage.sentDate = Date()
        
        return mimeMessage
    }
    
    /**
     * Validate email address format
     */
    fun isValidEmail(email: String): Boolean {
        return try {
            InternetAddress(email).validate()
            true
        } catch (e: AddressException) {
            false
        }
    }
    
    /**
     * Get supported email providers
     */
    fun getSupportedProviders(): List<String> {
        return SMTP_CONFIGS.keys.toList()
    }
    
    /**
     * Test email configuration
     */
    suspend fun testEmailConfiguration(account: EmailAccount): EmailResult = withContext(Dispatchers.IO) {
        try {
            val domain = account.email.substringAfter("@").lowercase()
            val smtpConfig = SMTP_CONFIGS[domain]
                ?: return@withContext EmailResult(false, "Unsupported email provider: $domain")
            
            val session = createSession(smtpConfig, account)
            val transport = session.getTransport("smtp")
            transport.connect()
            transport.close()
            
            EmailResult(true, "Email configuration is valid")
            
        } catch (e: Exception) {
            Log.e(TAG, "Email configuration test failed", e)
            EmailResult(false, "Configuration test failed: ${e.message}")
        }
    }
}

