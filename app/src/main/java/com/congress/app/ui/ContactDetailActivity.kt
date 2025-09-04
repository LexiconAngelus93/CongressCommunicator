package com.congress.app.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.congress.app.databinding.ActivityContactDetailBinding
import com.congress.app.db.CongressDatabase
import kotlinx.coroutines.launch

class ContactDetailActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityContactDetailBinding
    private var memberId: String? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        memberId = intent.getStringExtra("member_id")
        
        setupToolbar()
        loadMemberDetails()
        setupClickListeners()
    }
    
    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Contact Details"
    }
    
    private fun loadMemberDetails() {
        memberId?.let { id ->
            lifecycleScope.launch {
                val database = CongressDatabase.getDatabase(this@ContactDetailActivity)
                val member = database.congressMemberDao().getMemberById(id)
                
                member?.let {
                    binding.memberName.text = it.getFullTitle()
                    binding.memberParty.text = it.party
                    binding.memberChamber.text = it.chamber
                    binding.memberState.text = it.getStateDistrictDisplay()
                    binding.memberPhone.text = it.phoneNumber
                    binding.memberEmail.text = it.email
                    binding.memberWebsite.text = it.website ?: "Not available"
                    binding.memberOfficeAddress.text = it.getFormattedOfficeAddress() ?: "Not available"
                }
            }
        }
    }
    
    private fun setupClickListeners() {
        binding.btnSendEmail.setOnClickListener {
            val intent = Intent(this, EmailComposerActivity::class.java)
            intent.putExtra("member_id", memberId)
            startActivity(intent)
        }
        
        binding.btnMakeCall.setOnClickListener {
            val intent = Intent(this, CallingActivity::class.java)
            intent.putExtra("member_id", memberId)
            startActivity(intent)
        }
        
        binding.memberWebsite.setOnClickListener {
            val website = binding.memberWebsite.text.toString()
            if (website != "Not available" && website.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(website))
                startActivity(intent)
            }
        }
    }
    
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

