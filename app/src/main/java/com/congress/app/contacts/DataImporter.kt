package com.congress.app.contacts

import android.content.Context
import android.util.Log
import com.congress.app.db.CongressDatabase
import com.congress.app.db.CongressMember
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

/**
 * Imports and manages Congress member data from embedded JSON files
 */
class DataImporter(private val context: Context) {
    
    companion object {
        private const val TAG = "DataImporter"
        private const val CONGRESS_DATA_FILE = "congress_members.json"
    }
    
    private val database = CongressDatabase.getDatabase(context)
    private val dao = database.congressMemberDao()
    private val gson = Gson()
    
    data class ImportResult(
        val success: Boolean,
        val message: String,
        val importedCount: Int = 0,
        val skippedCount: Int = 0,
        val errorCount: Int = 0
    )
    
    /**
     * Import Congress member data from embedded JSON file
     */
    suspend fun importCongressData(): ImportResult = withContext(Dispatchers.IO) {
        try {
            Log.i(TAG, "Starting Congress data import...")
            
            // Check if data already exists
            val existingCount = dao.getTotalCount()
            if (existingCount > 0) {
                Log.i(TAG, "Data already exists ($existingCount members), skipping import")
                return@withContext ImportResult(
                    success = true,
                    message = "Data already imported",
                    importedCount = 0,
                    skippedCount = existingCount
                )
            }
            
            // Load data from assets or use embedded data
            val congressMembers = loadCongressMembersData()
            
            if (congressMembers.isEmpty()) {
                return@withContext ImportResult(
                    success = false,
                    message = "No Congress member data found"
                )
            }
            
            // Import data in batches
            val batchSize = 50
            var importedCount = 0
            var errorCount = 0
            
            congressMembers.chunked(batchSize).forEach { batch ->
                try {
                    dao.insertMembers(batch)
                    importedCount += batch.size
                    Log.d(TAG, "Imported batch of ${batch.size} members")
                } catch (e: Exception) {
                    Log.e(TAG, "Failed to import batch", e)
                    errorCount += batch.size
                }
            }
            
            Log.i(TAG, "Congress data import completed: $importedCount imported, $errorCount errors")
            
            ImportResult(
                success = errorCount == 0,
                message = if (errorCount == 0) {
                    "Successfully imported $importedCount Congress members"
                } else {
                    "Imported $importedCount members with $errorCount errors"
                },
                importedCount = importedCount,
                errorCount = errorCount
            )
            
        } catch (e: Exception) {
            Log.e(TAG, "Congress data import failed", e)
            ImportResult(
                success = false,
                message = "Import failed: ${e.message}"
            )
        }
    }
    
    /**
     * Load Congress members data from assets or embedded data
     */
    private fun loadCongressMembersData(): List<CongressMember> {
        return try {
            // Try to load from assets first
            val jsonString = loadFromAssets(CONGRESS_DATA_FILE)
            if (jsonString != null) {
                val type = object : TypeToken<List<CongressMember>>() {}.type
                gson.fromJson(jsonString, type) ?: getEmbeddedCongressData()
            } else {
                getEmbeddedCongressData()
            }
        } catch (e: Exception) {
            Log.w(TAG, "Failed to load from assets, using embedded data", e)
            getEmbeddedCongressData()
        }
    }
    
    /**
     * Load JSON file from assets
     */
    private fun loadFromAssets(fileName: String): String? {
        return try {
            context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (e: IOException) {
            Log.d(TAG, "Asset file not found: $fileName")
            null
        }
    }
    
    /**
     * Get embedded Congress member data (sample data for demonstration)
     */
    private fun getEmbeddedCongressData(): List<CongressMember> {
        return listOf(
            CongressMember(
                id = "P000197",
                firstName = "Nancy",
                lastName = "Pelosi",
                fullName = "Nancy Pelosi",
                title = "Rep.",
                party = "Democratic",
                chamber = "House of Representatives",
                state = "California",
                district = "11",
                stateCode = "CA",
                phoneNumber = "(202) 225-4965",
                email = "sf.nancy@mail.house.gov",
                website = "https://pelosi.house.gov",
                officeAddress = "1236 Longworth House Office Building",
                officeCity = "Washington",
                officeState = "DC",
                officeZip = "20515",
                bioguideId = "P000197",
                govtrackId = "400314",
                opensecretId = "N00007360",
                votesmartId = "26732",
                fecId = "H8CA05035",
                termStart = "2023-01-03",
                termEnd = "2025-01-03",
                twitter = "SpeakerPelosi",
                facebook = "NancyPelosi",
                youtube = "nancypelosi"
            ),
            CongressMember(
                id = "S000148",
                firstName = "Charles",
                lastName = "Schumer",
                fullName = "Charles E. Schumer",
                title = "Sen.",
                party = "Democratic",
                chamber = "Senate",
                state = "New York",
                stateCode = "NY",
                phoneNumber = "(202) 224-6542",
                email = "senator@schumer.senate.gov",
                website = "https://www.schumer.senate.gov",
                officeAddress = "322 Hart Senate Office Building",
                officeCity = "Washington",
                officeState = "DC",
                officeZip = "20510",
                bioguideId = "S000148",
                govtrackId = "300087",
                opensecretId = "N00001093",
                votesmartId = "26976",
                fecId = "S6NY00133",
                termStart = "2023-01-03",
                termEnd = "2029-01-03",
                senatorClass = "III",
                senatorRank = "senior",
                twitter = "SenSchumer",
                facebook = "senschumer",
                youtube = "SenatorSchumer"
            ),
            CongressMember(
                id = "M000355",
                firstName = "Mitch",
                lastName = "McConnell",
                fullName = "Addison Mitchell McConnell Jr.",
                title = "Sen.",
                party = "Republican",
                chamber = "Senate",
                state = "Kentucky",
                stateCode = "KY",
                phoneNumber = "(202) 224-2541",
                email = "senator@mcconnell.senate.gov",
                website = "https://www.mcconnell.senate.gov",
                officeAddress = "317 Russell Senate Office Building",
                officeCity = "Washington",
                officeState = "DC",
                officeZip = "20510",
                bioguideId = "M000355",
                govtrackId = "300072",
                opensecretId = "N00003389",
                votesmartId = "53298",
                fecId = "S4KY00012",
                termStart = "2021-01-03",
                termEnd = "2027-01-03",
                senatorClass = "II",
                senatorRank = "senior",
                twitter = "LeaderMcConnell",
                facebook = "mitchmcconnell",
                youtube = "McConnellPress"
            ),
            CongressMember(
                id = "J000289",
                firstName = "Jim",
                lastName = "Jordan",
                fullName = "James Daniel Jordan",
                title = "Rep.",
                party = "Republican",
                chamber = "House of Representatives",
                state = "Ohio",
                district = "4",
                stateCode = "OH",
                phoneNumber = "(202) 225-2676",
                email = "jordan@mail.house.gov",
                website = "https://jordan.house.gov",
                officeAddress = "2056 Rayburn House Office Building",
                officeCity = "Washington",
                officeState = "DC",
                officeZip = "20515",
                bioguideId = "J000289",
                govtrackId = "412226",
                opensecretId = "N00029070",
                votesmartId = "45653",
                fecId = "H6OH04117",
                termStart = "2023-01-03",
                termEnd = "2025-01-03",
                twitter = "Jim_Jordan",
                facebook = "RepJimJordan",
                youtube = "RepJimJordan"
            ),
            CongressMember(
                id = "A000369",
                firstName = "Mark",
                lastName = "Amodei",
                fullName = "Mark Eugene Amodei",
                title = "Rep.",
                party = "Republican",
                chamber = "House of Representatives",
                state = "Nevada",
                district = "2",
                stateCode = "NV",
                phoneNumber = "(202) 225-6155",
                email = "amodei@mail.house.gov",
                website = "https://amodei.house.gov",
                officeAddress = "104 Cannon House Office Building",
                officeCity = "Washington",
                officeState = "DC",
                officeZip = "20515",
                bioguideId = "A000369",
                govtrackId = "412500",
                opensecretId = "N00031877",
                votesmartId = "1707",
                fecId = "H1NV02156",
                termStart = "2023-01-03",
                termEnd = "2025-01-03",
                twitter = "MarkAmodeiNV2",
                facebook = "MarkAmodeiNV2"
            )
        )
    }
    
    /**
     * Update Congress member data
     */
    suspend fun updateCongressData(): ImportResult = withContext(Dispatchers.IO) {
        try {
            Log.i(TAG, "Updating Congress data...")
            
            // Clear existing data
            dao.deleteAllMembers()
            
            // Import fresh data
            importCongressData()
            
        } catch (e: Exception) {
            Log.e(TAG, "Congress data update failed", e)
            ImportResult(
                success = false,
                message = "Update failed: ${e.message}"
            )
        }
    }
    
    /**
     * Check if data needs updating
     */
    suspend fun needsUpdate(): Boolean = withContext(Dispatchers.IO) {
        try {
            val lastUpdate = dao.getLastUpdateTime() ?: 0
            val daysSinceUpdate = (System.currentTimeMillis() - lastUpdate) / (24 * 60 * 60 * 1000)
            
            // Update if data is older than 30 days or if no data exists
            daysSinceUpdate > 30 || dao.getTotalCount() == 0
            
        } catch (e: Exception) {
            Log.e(TAG, "Failed to check update status", e)
            true // Assume update needed on error
        }
    }
    
    /**
     * Get import statistics
     */
    suspend fun getImportStats(): Map<String, Int> = withContext(Dispatchers.IO) {
        try {
            mapOf(
                "total" to dao.getMemberCount(),
                "house" to dao.getMemberCountByChamber("House of Representatives"),
                "senate" to dao.getMemberCountByChamber("Senate"),
                "democratic" to dao.getMemberCountByParty("Democratic"),
                "republican" to dao.getMemberCountByParty("Republican"),
                "independent" to dao.getMemberCountByParty("Independent")
            )
        } catch (e: Exception) {
            Log.e(TAG, "Failed to get import stats", e)
            emptyMap()
        }
    }
}

