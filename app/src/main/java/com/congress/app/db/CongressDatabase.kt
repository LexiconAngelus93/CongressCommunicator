package com.congress.app.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

/**
 * Room database for Congress member data
 */
@Database(
    entities = [CongressMember::class],
    version = 1,
    exportSchema = false
)
abstract class CongressDatabase : RoomDatabase() {
    
    abstract fun congressMemberDao(): CongressMemberDao
    
    companion object {
        @Volatile
        private var INSTANCE: CongressDatabase? = null
        
        private const val DATABASE_NAME = "congress_database"
        
        fun getDatabase(context: Context): CongressDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CongressDatabase::class.java,
                    DATABASE_NAME
                )
                .addCallback(DatabaseCallback())
                .build()
                INSTANCE = instance
                instance
            }
        }
        
        /**
         * Database callback for initialization
         */
        private class DatabaseCallback : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                // Database created - initial data will be populated by DataImporter
            }
        }
        
        /**
         * Migration from version 1 to 2 (for future use)
         */
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Add migration logic here when needed
            }
        }
    }
}

