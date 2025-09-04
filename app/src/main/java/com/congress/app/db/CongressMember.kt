package com.congress.app.db

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity representing a US Congress member with all contact information
 */
@Entity(tableName = "congress_members")
data class CongressMember(
    @PrimaryKey
    val id: String,
    
    // Basic Information
    val firstName: String,
    val lastName: String,
    val fullName: String,
    val title: String, // "Rep." or "Sen."
    val party: String, // "Democratic", "Republican", "Independent"
    val chamber: String, // "House of Representatives" or "Senate"
    
    // Location Information
    val state: String,
    val district: String? = null, // Only for House members
    val stateCode: String, // Two-letter state code
    
    // Contact Information
    val phoneNumber: String,
    val email: String,
    val website: String? = null,
    
    // Office Information
    val officeAddress: String? = null,
    val officeCity: String? = null,
    val officeState: String? = null,
    val officeZip: String? = null,
    val officeBuilding: String? = null,
    val officeRoom: String? = null,
    
    // Additional Information
    val bioguideId: String? = null,
    val govtrackId: String? = null,
    val opensecretId: String? = null,
    val votesmartId: String? = null,
    val fecId: String? = null,
    val cspanId: String? = null,
    val wikipediaId: String? = null,
    val ballotpediaId: String? = null,
    val houseHistoryId: String? = null,
    val senateHistoryId: String? = null,
    
    // Terms
    val termStart: String? = null,
    val termEnd: String? = null,
    val senatorClass: String? = null, // Only for Senators (Class I, II, or III)
    val senatorRank: String? = null, // "junior" or "senior"
    
    // Social Media
    val twitter: String? = null,
    val facebook: String? = null,
    val youtube: String? = null,
    val instagram: String? = null,
    
    // Metadata
    val lastUpdated: Long = System.currentTimeMillis(),
    val isActive: Boolean = true
) {
    
    /**
     * Get formatted display name
     */
    fun getDisplayName(): String {
        return "$lastName, $firstName"
    }
    
    /**
     * Get full title with name
     */
    fun getFullTitle(): String {
        return "$title $firstName $lastName"
    }
    
    /**
     * Get party abbreviation
     */
    fun getPartyAbbreviation(): String {
        return when (party.lowercase()) {
            "democratic" -> "D"
            "republican" -> "R"
            "independent" -> "I"
            else -> party.take(1).uppercase()
        }
    }
    
    /**
     * Get chamber abbreviation
     */
    fun getChamberAbbreviation(): String {
        return when (chamber) {
            "House of Representatives" -> "House"
            "Senate" -> "Senate"
            else -> chamber
        }
    }
    
    /**
     * Get state and district display
     */
    fun getStateDistrictDisplay(): String {
        return if (district != null) {
            "$state, District $district"
        } else {
            state
        }
    }
    
    /**
     * Get formatted office address
     */
    fun getFormattedOfficeAddress(): String? {
        return if (officeAddress != null) {
            buildString {
                append(officeAddress)
                if (officeCity != null) {
                    append("\n$officeCity")
                    if (officeState != null) {
                        append(", $officeState")
                    }
                    if (officeZip != null) {
                        append(" $officeZip")
                    }
                }
            }
        } else {
            null
        }
    }
    
    /**
     * Check if member is a Senator
     */
    fun isSenator(): Boolean {
        return chamber == "Senate"
    }
    
    /**
     * Check if member is a Representative
     */
    fun isRepresentative(): Boolean {
        return chamber == "House of Representatives"
    }
    
    /**
     * Get search keywords for filtering
     */
    fun getSearchKeywords(): String {
        return listOfNotNull(
            firstName,
            lastName,
            fullName,
            party,
            chamber,
            state,
            district,
            stateCode
        ).joinToString(" ").lowercase()
    }
}

