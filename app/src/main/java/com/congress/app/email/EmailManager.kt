package com.congress.app.email

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Manages email accounts, aliases, and templates for the Congress Communication app
 */
class EmailManager(private val context: Context) {
    
    companion object {
        private const val PREFS_NAME = "email_preferences"
        private const val KEY_EMAIL_ACCOUNTS = "email_accounts"
        private const val KEY_EMAIL_TEMPLATES = "email_templates"
        private const val KEY_DEFAULT_ACCOUNT = "default_account"
    }
    
    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    private val gson = Gson()
    private val emailService = EmailService(context)
    
    data class EmailTemplate(
        val id: String,
        val name: String,
        val subject: String,
        val body: String,
        val isHtml: Boolean = false
    )
    
    /**
     * Save email account with encryption for password
     */
    fun saveEmailAccount(account: EmailService.EmailAccount) {
        val accounts = getEmailAccounts().toMutableList()
        
        // Remove existing account with same email
        accounts.removeAll { it.email == account.email }
        
        // Add new/updated account
        accounts.add(account)
        
        val json = gson.toJson(accounts)
        prefs.edit().putString(KEY_EMAIL_ACCOUNTS, json).apply()
    }
    
    /**
     * Get all saved email accounts
     */
    fun getEmailAccounts(): List<EmailService.EmailAccount> {
        val json = prefs.getString(KEY_EMAIL_ACCOUNTS, null) ?: return emptyList()
        val type = object : TypeToken<List<EmailService.EmailAccount>>() {}.type
        return gson.fromJson(json, type) ?: emptyList()
    }
    
    /**
     * Get email account by email address
     */
    fun getEmailAccount(email: String): EmailService.EmailAccount? {
        return getEmailAccounts().find { it.email == email }
    }
    
    /**
     * Remove email account
     */
    fun removeEmailAccount(email: String) {
        val accounts = getEmailAccounts().toMutableList()
        accounts.removeAll { it.email == email }
        
        val json = gson.toJson(accounts)
        prefs.edit().putString(KEY_EMAIL_ACCOUNTS, json).apply()
    }
    
    /**
     * Set default email account
     */
    fun setDefaultAccount(email: String) {
        prefs.edit().putString(KEY_DEFAULT_ACCOUNT, email).apply()
    }
    
    /**
     * Get default email account
     */
    fun getDefaultAccount(): EmailService.EmailAccount? {
        val defaultEmail = prefs.getString(KEY_DEFAULT_ACCOUNT, null) ?: return null
        return getEmailAccount(defaultEmail)
    }
    
    /**
     * Save email template
     */
    fun saveEmailTemplate(template: EmailTemplate) {
        val templates = getEmailTemplates().toMutableList()
        
        // Remove existing template with same ID
        templates.removeAll { it.id == template.id }
        
        // Add new/updated template
        templates.add(template)
        
        val json = gson.toJson(templates)
        prefs.edit().putString(KEY_EMAIL_TEMPLATES, json).apply()
    }
    
    /**
     * Get all email templates
     */
    fun getEmailTemplates(): List<EmailTemplate> {
        val json = prefs.getString(KEY_EMAIL_TEMPLATES, null) ?: return getDefaultTemplates()
        val type = object : TypeToken<List<EmailTemplate>>() {}.type
        return gson.fromJson(json, type) ?: getDefaultTemplates()
    }
    
    /**
     * Get email template by ID
     */
    fun getEmailTemplate(id: String): EmailTemplate? {
        return getEmailTemplates().find { it.id == id }
    }
    
    /**
     * Remove email template
     */
    fun removeEmailTemplate(id: String) {
        val templates = getEmailTemplates().toMutableList()
        templates.removeAll { it.id == id }
        
        val json = gson.toJson(templates)
        prefs.edit().putString(KEY_EMAIL_TEMPLATES, json).apply()
    }
    
    /**
     * Get default email templates for Congress communication
     */
    private fun getDefaultTemplates(): List<EmailTemplate> {
        return listOf(
            EmailTemplate(
                id = "support_bill",
                name = "Support Bill",
                subject = "Please Support [Bill Number/Title]",
                body = """Dear [Representative/Senator] [Last Name],

I am writing as your constituent to urge you to support [Bill Number/Title].

[Explain why this bill is important to you and your community]

This legislation would [describe the positive impact].

I respectfully ask that you vote in favor of this important bill.

Thank you for your time and consideration.

Sincerely,
[Your Name]
[Your Address]
[Your City, State ZIP]"""
            ),
            EmailTemplate(
                id = "oppose_bill",
                name = "Oppose Bill",
                subject = "Please Oppose [Bill Number/Title]",
                body = """Dear [Representative/Senator] [Last Name],

I am writing as your constituent to urge you to oppose [Bill Number/Title].

[Explain your concerns about this bill]

This legislation would [describe the negative impact].

I respectfully ask that you vote against this bill.

Thank you for your time and consideration.

Sincerely,
[Your Name]
[Your Address]
[Your City, State ZIP]"""
            ),
            EmailTemplate(
                id = "general_concern",
                name = "General Concern",
                subject = "Constituent Concern: [Issue]",
                body = """Dear [Representative/Senator] [Last Name],

I am writing as your constituent to express my concern about [Issue].

[Describe the issue and why it matters to you]

I would appreciate your attention to this matter and would like to know your position on this issue.

Thank you for your service and for representing our interests.

Sincerely,
[Your Name]
[Your Address]
[Your City, State ZIP]"""
            ),
            EmailTemplate(
                id = "thank_you",
                name = "Thank You",
                subject = "Thank You for Your Vote on [Bill/Issue]",
                body = """Dear [Representative/Senator] [Last Name],

I am writing to thank you for your recent vote on [Bill/Issue].

Your support of [specific action] demonstrates your commitment to [values/principles].

As your constituent, I appreciate your leadership on this important issue.

Thank you for representing our interests.

Sincerely,
[Your Name]
[Your Address]
[Your City, State ZIP]"""
            )
        )
    }
    
    /**
     * Create personalized email message for a Congress member
     */
    fun createPersonalizedMessage(
        template: EmailTemplate,
        memberName: String,
        memberTitle: String,
        userInfo: Map<String, String> = emptyMap()
    ): EmailService.EmailMessage {
        var subject = template.subject
        var body = template.body
        
        // Replace placeholders
        val replacements = mapOf<String, String>(
            Pair("[Representative/Senator]", memberTitle),
            Pair("[Last Name]", memberName.split(",").firstOrNull()?.trim() ?: memberName),
            Pair("[Your Name]", userInfo["name"] ?: "[Your Name]"),
            Pair("[Your Address]", userInfo["address"] ?: "[Your Address]"),
            Pair("[Your City, State ZIP]", userInfo["cityStateZip"] ?: "[Your City, State ZIP]")
        )
        
        replacements.forEach { (placeholder, replacement) ->
            subject = subject.replace(placeholder, replacement)
            body = body.replace(placeholder, replacement)
        }
        
        return EmailService.EmailMessage(
            to = emptyList(), // Will be set by caller
            subject = subject,
            body = body,
            isHtml = template.isHtml
        )
    }
    
    /**
     * Validate email account configuration
     */
    suspend fun validateAccount(account: EmailService.EmailAccount): EmailService.EmailResult {
        return emailService.testEmailConfiguration(account)
    }
    
    /**
     * Send email using specified account
     */
    suspend fun sendEmail(
        accountEmail: String,
        message: EmailService.EmailMessage
    ): EmailService.EmailResult {
        val account = getEmailAccount(accountEmail)
            ?: return EmailService.EmailResult(false, "Email account not found: $accountEmail")
        
        return emailService.sendEmail(account, message)
    }
    
    /**
     * Send batch emails using specified account
     */
    suspend fun sendBatchEmails(
        accountEmail: String,
        messages: List<EmailService.EmailMessage>
    ): EmailService.EmailResult {
        val account = getEmailAccount(accountEmail)
            ?: return EmailService.EmailResult(false, "Email account not found: $accountEmail")
        
        return emailService.sendBatchEmails(account, messages)
    }
}

