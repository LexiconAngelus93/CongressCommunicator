package com.congress.app.ui

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.congress.app.R
import com.congress.app.databinding.ActivityMainBinding
import com.congress.app.db.CongressMember
import com.congress.app.ui.adapters.CongressMemberAdapter
import com.congress.app.ui.viewmodels.MainViewModel
import com.google.android.material.chip.Chip

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: CongressMemberAdapter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setupToolbar()
        setupRecyclerView()
        setupViewModel()
        setupSearchAndFilters()
        setupFABs()
    }
    
    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = getString(R.string.app_name)
    }
    
    private fun setupRecyclerView() {
        adapter = CongressMemberAdapter(
            onItemClick = { member ->
                val intent = Intent(this, ContactDetailActivity::class.java)
                intent.putExtra("member_id", member.id)
                startActivity(intent)
            },
            onEmailClick = { member ->
                val intent = Intent(this, EmailComposerActivity::class.java)
                intent.putExtra("member_id", member.id)
                startActivity(intent)
            },
            onCallClick = { member ->
                val intent = Intent(this, CallingActivity::class.java)
                intent.putExtra("member_id", member.id)
                startActivity(intent)
            }
        )
        
        binding.congressMembersRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.congressMembersRecyclerView.adapter = adapter
    }
    
    private fun setupViewModel() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        
        viewModel.congressMembers.observe(this) { members ->
            adapter.submitList(members)
        }
        
        viewModel.loadCongressMembers()
    }
    
    private fun setupSearchAndFilters() {
        // Search functionality
        binding.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                viewModel.searchMembers(s.toString())
            }
        })
        
        // Filter chips
        binding.filterChipGroup.setOnCheckedStateChangeListener { group, checkedIds ->
            val filters = mutableListOf<String>()
            
            checkedIds.forEach { chipId ->
                val chip = findViewById<Chip>(chipId)
                when (chipId) {
                    R.id.chipHouse -> filters.add("House of Representatives")
                    R.id.chipSenate -> filters.add("Senate")
                    R.id.chipDemocrat -> filters.add("Democratic")
                    R.id.chipRepublican -> filters.add("Republican")
                    R.id.chipIndependent -> filters.add("Independent")
                }
            }
            
            if (binding.chipAll.isChecked || filters.isEmpty()) {
                viewModel.clearFilters()
            } else {
                viewModel.applyFilters(filters)
            }
        }
    }
    
    private fun setupFABs() {
        binding.fabEmail.setOnClickListener {
            val intent = Intent(this, EmailComposerActivity::class.java)
            intent.putExtra("batch_mode", true)
            startActivity(intent)
        }
        
        binding.fabCall.setOnClickListener {
            val intent = Intent(this, CallingActivity::class.java)
            intent.putExtra("batch_mode", true)
            startActivity(intent)
        }
    }
}

