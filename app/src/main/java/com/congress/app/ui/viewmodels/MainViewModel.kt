package com.congress.app.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.congress.app.contacts.DataImporter
import com.congress.app.db.CongressDatabase
import com.congress.app.db.CongressMember
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    
    private val database = CongressDatabase.getDatabase(application)
    private val dao = database.congressMemberDao()
    private val dataImporter = DataImporter(application)
    
    // Search and filter state
    private val searchQuery = MutableStateFlow("")
    private val selectedChambers = MutableStateFlow<Set<String>>(emptySet())
    private val selectedParties = MutableStateFlow<Set<String>>(emptySet())
    private val selectedStates = MutableStateFlow<Set<String>>(emptySet())
    
    // Loading state
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    
    // Error state
    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error
    
    // Import status
    private val _importStatus = MutableLiveData<String>()
    val importStatus: LiveData<String> = _importStatus
    
    // Combined flow for filtered members
    val congressMembers: LiveData<List<CongressMember>> = combine(
        dao.getAllMembers(),
        searchQuery,
        selectedChambers,
        selectedParties,
        selectedStates
    ) { allMembers, query, chambers, parties, states ->
        filterMembers(allMembers, query, chambers, parties, states)
    }.asLiveData()
    
    init {
        loadCongressMembers()
    }
    
    /**
     * Load Congress members data
     */
    fun loadCongressMembers() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _error.value = null
                
                // Check if data needs importing
                val memberCount = dao.getMemberCount()
                if (memberCount == 0) {
                    _importStatus.value = "Importing Congress member data..."
                    val result = dataImporter.importCongressData()
                    
                    if (result.success) {
                        _importStatus.value = "Successfully imported ${result.importedCount} members"
                    } else {
                        _error.value = result.message
                    }
                }
                
            } catch (e: Exception) {
                _error.value = "Failed to load Congress members: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    /**
     * Search members by query
     */
    fun searchMembers(query: String) {
        searchQuery.value = query.trim()
    }
    
    /**
     * Apply chamber filters
     */
    fun applyFilters(filters: List<String>) {
        val chambers = mutableSetOf<String>()
        val parties = mutableSetOf<String>()
        val states = mutableSetOf<String>()
        
        filters.forEach { filter ->
            when (filter) {
                "House of Representatives" -> chambers.add(filter)
                "Senate" -> chambers.add(filter)
                "Democratic" -> parties.add(filter)
                "Republican" -> parties.add(filter)
                "Independent" -> parties.add(filter)
                else -> {
                    // Assume it's a state if not recognized
                    if (filter.length == 2) {
                        states.add(filter)
                    }
                }
            }
        }
        
        selectedChambers.value = chambers
        selectedParties.value = parties
        selectedStates.value = states
    }
    
    /**
     * Clear all filters
     */
    fun clearFilters() {
        searchQuery.value = ""
        selectedChambers.value = emptySet()
        selectedParties.value = emptySet()
        selectedStates.value = emptySet()
    }
    
    /**
     * Filter members based on search and filters
     */
    private fun filterMembers(
        members: List<CongressMember>,
        query: String,
        chambers: Set<String>,
        parties: Set<String>,
        states: Set<String>
    ): List<CongressMember> {
        return members.filter { member ->
            // Search query filter
            val matchesQuery = if (query.isEmpty()) {
                true
            } else {
                member.getSearchKeywords().contains(query.lowercase())
            }
            
            // Chamber filter
            val matchesChamber = if (chambers.isEmpty()) {
                true
            } else {
                chambers.contains(member.chamber)
            }
            
            // Party filter
            val matchesParty = if (parties.isEmpty()) {
                true
            } else {
                parties.contains(member.party)
            }
            
            // State filter
            val matchesState = if (states.isEmpty()) {
                true
            } else {
                states.contains(member.state) || states.contains(member.stateCode)
            }
            
            matchesQuery && matchesChamber && matchesParty && matchesState
        }
    }
    
    /**
     * Get member by ID
     */
    suspend fun getMemberById(id: String): CongressMember? {
        return dao.getMemberById(id)
    }
    
    /**
     * Get all email addresses
     */
    suspend fun getAllEmailAddresses(): List<String> {
        return dao.getAllEmailAddresses()
    }
    
    /**
     * Get all phone numbers
     */
    suspend fun getAllPhoneNumbers(): List<String> {
        return dao.getAllPhoneNumbers()
    }
    
    /**
     * Get members with email
     */
    suspend fun getMembersWithEmail(): List<CongressMember> {
        return dao.getMembersWithEmail()
    }
    
    /**
     * Get members with phone
     */
    suspend fun getMembersWithPhone(): List<CongressMember> {
        return dao.getMembersWithPhone()
    }
    
    /**
     * Update Congress data
     */
    fun updateCongressData() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _importStatus.value = "Updating Congress member data..."
                
                val result = dataImporter.updateCongressData()
                
                if (result.success) {
                    _importStatus.value = "Successfully updated ${result.importedCount} members"
                } else {
                    _error.value = result.message
                }
                
            } catch (e: Exception) {
                _error.value = "Failed to update Congress data: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    /**
     * Get import statistics
     */
    fun getImportStats() {
        viewModelScope.launch {
            try {
                val stats = dataImporter.getImportStats()
                val message = buildString {
                    append("Database Statistics:\n")
                    append("Total Members: ${stats["total"] ?: 0}\n")
                    append("House: ${stats["house"] ?: 0}\n")
                    append("Senate: ${stats["senate"] ?: 0}\n")
                    append("Democrats: ${stats["democratic"] ?: 0}\n")
                    append("Republicans: ${stats["republican"] ?: 0}\n")
                    append("Independents: ${stats["independent"] ?: 0}")
                }
                _importStatus.value = message
            } catch (e: Exception) {
                _error.value = "Failed to get statistics: ${e.message}"
            }
        }
    }
    
    /**
     * Clear error message
     */
    fun clearError() {
        _error.value = null
    }
    
    /**
     * Clear import status
     */
    fun clearImportStatus() {
        _importStatus.value = ""
    }
}

