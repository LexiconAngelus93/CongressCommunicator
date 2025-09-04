package com.congress.app.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for Congress members
 */
@Dao
interface CongressMemberDao {
    
    /**
     * Get all Congress members
     */
    @Query("SELECT * FROM congress_members WHERE isActive = 1 ORDER BY lastName, firstName")
    fun getAllMembers(): Flow<List<CongressMember>>
    
    /**
     * Get all Congress members as list (for one-time operations)
     */
    @Query("SELECT * FROM congress_members WHERE isActive = 1 ORDER BY lastName, firstName")
    suspend fun getAllMembersList(): List<CongressMember>
    
    /**
     * Get member by ID
     */
    @Query("SELECT * FROM congress_members WHERE id = :id")
    suspend fun getMemberById(id: String): CongressMember?
    
    /**
     * Search members by name, state, or party
     */
    @Query("""
        SELECT * FROM congress_members 
        WHERE isActive = 1 AND (
            firstName LIKE '%' || :query || '%' OR
            lastName LIKE '%' || :query || '%' OR
            fullName LIKE '%' || :query || '%' OR
            state LIKE '%' || :query || '%' OR
            party LIKE '%' || :query || '%'
        )
        ORDER BY lastName, firstName
    """)
    fun searchMembers(query: String): Flow<List<CongressMember>>
    
    /**
     * Get members by chamber
     */
    @Query("SELECT * FROM congress_members WHERE isActive = 1 AND chamber = :chamber ORDER BY lastName, firstName")
    fun getMembersByChamber(chamber: String): Flow<List<CongressMember>>
    
    /**
     * Get members by party
     */
    @Query("SELECT * FROM congress_members WHERE isActive = 1 AND party = :party ORDER BY lastName, firstName")
    fun getMembersByParty(party: String): Flow<List<CongressMember>>
    
    /**
     * Get members by state
     */
    @Query("SELECT * FROM congress_members WHERE isActive = 1 AND state = :state ORDER BY lastName, firstName")
    fun getMembersByState(state: String): Flow<List<CongressMember>>
    
    /**
     * Get members by multiple filters
     */
    @Query("""
        SELECT * FROM congress_members 
        WHERE isActive = 1 
        AND (:chamber IS NULL OR chamber = :chamber)
        AND (:party IS NULL OR party = :party)
        AND (:state IS NULL OR state = :state)
        ORDER BY lastName, firstName
    """)
    fun getMembersByFilters(
        chamber: String? = null,
        party: String? = null,
        state: String? = null
    ): Flow<List<CongressMember>>
    
    /**
     * Get all email addresses
     */
    @Query("SELECT email FROM congress_members WHERE isActive = 1 AND email != ''")
    suspend fun getAllEmailAddresses(): List<String>
    
    /**
     * Get all phone numbers
     */
    @Query("SELECT phoneNumber FROM congress_members WHERE isActive = 1 AND phoneNumber != ''")
    suspend fun getAllPhoneNumbers(): List<String>
    
    /**
     * Get members with email addresses
     */
    @Query("SELECT * FROM congress_members WHERE isActive = 1 AND email != '' ORDER BY lastName, firstName")
    suspend fun getMembersWithEmail(): List<CongressMember>
    
    /**
     * Get members with phone numbers
     */
    @Query("SELECT * FROM congress_members WHERE isActive = 1 AND phoneNumber != '' ORDER BY lastName, firstName")
    suspend fun getMembersWithPhone(): List<CongressMember>
    
    /**
     * Insert single member
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMember(member: CongressMember)
    
    /**
     * Insert multiple members
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMembers(members: List<CongressMember>)
    
    /**
     * Update member
     */
    @Update
    suspend fun updateMember(member: CongressMember)
    
    /**
     * Delete member
     */
    @Delete
    suspend fun deleteMember(member: CongressMember)
    
    /**
     * Delete all members
     */
    @Query("DELETE FROM congress_members")
    suspend fun deleteAllMembers()
    
    /**
     * Mark member as inactive
     */
    @Query("UPDATE congress_members SET isActive = 0 WHERE id = :id")
    suspend fun deactivateMember(id: String)
    
    /**
     * Get count of members
     */
    @Query("SELECT COUNT(*) FROM congress_members WHERE isActive = 1")
    suspend fun getMemberCount(): Int
    
    /**
     * Get count by chamber
     */
    @Query("SELECT COUNT(*) FROM congress_members WHERE isActive = 1 AND chamber = :chamber")
    suspend fun getMemberCountByChamber(chamber: String): Int
    
    /**
     * Get count by party
     */
    @Query("SELECT COUNT(*) FROM congress_members WHERE isActive = 1 AND party = :party")
    suspend fun getMemberCountByParty(party: String): Int
    
    /**
     * Get all states represented
     */
    @Query("SELECT DISTINCT state FROM congress_members WHERE isActive = 1 ORDER BY state")
    suspend fun getAllStates(): List<String>
    
    /**
     * Get all parties
     */
    @Query("SELECT DISTINCT party FROM congress_members WHERE isActive = 1 ORDER BY party")
    suspend fun getAllParties(): List<String>
    
    /**
     * Check if database is empty
     */
    @Query("SELECT COUNT(*) FROM congress_members")
    suspend fun getTotalCount(): Int
    
    /**
     * Get last update timestamp
     */
    @Query("SELECT MAX(lastUpdated) FROM congress_members")
    suspend fun getLastUpdateTime(): Long?
}

