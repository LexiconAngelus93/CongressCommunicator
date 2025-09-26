package com.congress.app.db

import androidx.room.InvalidationTracker
import androidx.room.RoomOpenDelegate
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.room.util.TableInfo
import androidx.room.util.TableInfo.Companion.read
import androidx.room.util.dropFtsSyncTriggers
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.execSQL
import kotlin.Lazy
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.MutableList
import kotlin.collections.MutableMap
import kotlin.collections.MutableSet
import kotlin.collections.Set
import kotlin.collections.mutableListOf
import kotlin.collections.mutableMapOf
import kotlin.collections.mutableSetOf
import kotlin.reflect.KClass

@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class CongressDatabase_Impl : CongressDatabase() {
  private val _congressMemberDao: Lazy<CongressMemberDao> = lazy {
    CongressMemberDao_Impl(this)
  }

  protected override fun createOpenDelegate(): RoomOpenDelegate {
    val _openDelegate: RoomOpenDelegate = object : RoomOpenDelegate(1, "de555ddef43180c07770d2a4786bdc33", "75d55f3dc9e18ad3b146aa08c4e7fc44") {
      public override fun createAllTables(connection: SQLiteConnection) {
        connection.execSQL("CREATE TABLE IF NOT EXISTS `congress_members` (`id` TEXT NOT NULL, `firstName` TEXT NOT NULL, `lastName` TEXT NOT NULL, `fullName` TEXT NOT NULL, `title` TEXT NOT NULL, `party` TEXT NOT NULL, `chamber` TEXT NOT NULL, `state` TEXT NOT NULL, `district` TEXT, `stateCode` TEXT NOT NULL, `phoneNumber` TEXT NOT NULL, `email` TEXT NOT NULL, `website` TEXT, `officeAddress` TEXT, `officeCity` TEXT, `officeState` TEXT, `officeZip` TEXT, `officeBuilding` TEXT, `officeRoom` TEXT, `bioguideId` TEXT, `govtrackId` TEXT, `opensecretId` TEXT, `votesmartId` TEXT, `fecId` TEXT, `cspanId` TEXT, `wikipediaId` TEXT, `ballotpediaId` TEXT, `houseHistoryId` TEXT, `senateHistoryId` TEXT, `termStart` TEXT, `termEnd` TEXT, `senatorClass` TEXT, `senatorRank` TEXT, `twitter` TEXT, `facebook` TEXT, `youtube` TEXT, `instagram` TEXT, `lastUpdated` INTEGER NOT NULL, `isActive` INTEGER NOT NULL, PRIMARY KEY(`id`))")
        connection.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)")
        connection.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'de555ddef43180c07770d2a4786bdc33')")
      }

      public override fun dropAllTables(connection: SQLiteConnection) {
        connection.execSQL("DROP TABLE IF EXISTS `congress_members`")
      }

      public override fun onCreate(connection: SQLiteConnection) {
      }

      public override fun onOpen(connection: SQLiteConnection) {
        internalInitInvalidationTracker(connection)
      }

      public override fun onPreMigrate(connection: SQLiteConnection) {
        dropFtsSyncTriggers(connection)
      }

      public override fun onPostMigrate(connection: SQLiteConnection) {
      }

      public override fun onValidateSchema(connection: SQLiteConnection): RoomOpenDelegate.ValidationResult {
        val _columnsCongressMembers: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsCongressMembers.put("id", TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("firstName", TableInfo.Column("firstName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("lastName", TableInfo.Column("lastName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("fullName", TableInfo.Column("fullName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("title", TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("party", TableInfo.Column("party", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("chamber", TableInfo.Column("chamber", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("state", TableInfo.Column("state", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("district", TableInfo.Column("district", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("stateCode", TableInfo.Column("stateCode", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("phoneNumber", TableInfo.Column("phoneNumber", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("email", TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("website", TableInfo.Column("website", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("officeAddress", TableInfo.Column("officeAddress", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("officeCity", TableInfo.Column("officeCity", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("officeState", TableInfo.Column("officeState", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("officeZip", TableInfo.Column("officeZip", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("officeBuilding", TableInfo.Column("officeBuilding", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("officeRoom", TableInfo.Column("officeRoom", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("bioguideId", TableInfo.Column("bioguideId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("govtrackId", TableInfo.Column("govtrackId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("opensecretId", TableInfo.Column("opensecretId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("votesmartId", TableInfo.Column("votesmartId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("fecId", TableInfo.Column("fecId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("cspanId", TableInfo.Column("cspanId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("wikipediaId", TableInfo.Column("wikipediaId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("ballotpediaId", TableInfo.Column("ballotpediaId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("houseHistoryId", TableInfo.Column("houseHistoryId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("senateHistoryId", TableInfo.Column("senateHistoryId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("termStart", TableInfo.Column("termStart", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("termEnd", TableInfo.Column("termEnd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("senatorClass", TableInfo.Column("senatorClass", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("senatorRank", TableInfo.Column("senatorRank", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("twitter", TableInfo.Column("twitter", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("facebook", TableInfo.Column("facebook", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("youtube", TableInfo.Column("youtube", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("instagram", TableInfo.Column("instagram", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("lastUpdated", TableInfo.Column("lastUpdated", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsCongressMembers.put("isActive", TableInfo.Column("isActive", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysCongressMembers: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesCongressMembers: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoCongressMembers: TableInfo = TableInfo("congress_members", _columnsCongressMembers, _foreignKeysCongressMembers, _indicesCongressMembers)
        val _existingCongressMembers: TableInfo = read(connection, "congress_members")
        if (!_infoCongressMembers.equals(_existingCongressMembers)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |congress_members(com.congress.app.db.CongressMember).
              | Expected:
              |""".trimMargin() + _infoCongressMembers + """
              |
              | Found:
              |""".trimMargin() + _existingCongressMembers)
        }
        return RoomOpenDelegate.ValidationResult(true, null)
      }
    }
    return _openDelegate
  }

  protected override fun createInvalidationTracker(): InvalidationTracker {
    val _shadowTablesMap: MutableMap<String, String> = mutableMapOf()
    val _viewTables: MutableMap<String, Set<String>> = mutableMapOf()
    return InvalidationTracker(this, _shadowTablesMap, _viewTables, "congress_members")
  }

  public override fun clearAllTables() {
    super.performClear(false, "congress_members")
  }

  protected override fun getRequiredTypeConverterClasses(): Map<KClass<*>, List<KClass<*>>> {
    val _typeConvertersMap: MutableMap<KClass<*>, List<KClass<*>>> = mutableMapOf()
    _typeConvertersMap.put(CongressMemberDao::class, CongressMemberDao_Impl.getRequiredConverters())
    return _typeConvertersMap
  }

  public override fun getRequiredAutoMigrationSpecClasses(): Set<KClass<out AutoMigrationSpec>> {
    val _autoMigrationSpecsSet: MutableSet<KClass<out AutoMigrationSpec>> = mutableSetOf()
    return _autoMigrationSpecsSet
  }

  public override fun createAutoMigrations(autoMigrationSpecs: Map<KClass<out AutoMigrationSpec>, AutoMigrationSpec>): List<Migration> {
    val _autoMigrations: MutableList<Migration> = mutableListOf()
    return _autoMigrations
  }

  public override fun congressMemberDao(): CongressMemberDao = _congressMemberDao.value
}
