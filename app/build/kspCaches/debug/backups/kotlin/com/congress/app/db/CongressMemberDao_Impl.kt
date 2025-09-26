package com.congress.app.db

import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass
import kotlinx.coroutines.flow.Flow

@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class CongressMemberDao_Impl(
  __db: RoomDatabase,
) : CongressMemberDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfCongressMember: EntityInsertAdapter<CongressMember>

  private val __deleteAdapterOfCongressMember: EntityDeleteOrUpdateAdapter<CongressMember>

  private val __updateAdapterOfCongressMember: EntityDeleteOrUpdateAdapter<CongressMember>
  init {
    this.__db = __db
    this.__insertAdapterOfCongressMember = object : EntityInsertAdapter<CongressMember>() {
      protected override fun createQuery(): String = "INSERT OR REPLACE INTO `congress_members` (`id`,`firstName`,`lastName`,`fullName`,`title`,`party`,`chamber`,`state`,`district`,`stateCode`,`phoneNumber`,`email`,`website`,`officeAddress`,`officeCity`,`officeState`,`officeZip`,`officeBuilding`,`officeRoom`,`bioguideId`,`govtrackId`,`opensecretId`,`votesmartId`,`fecId`,`cspanId`,`wikipediaId`,`ballotpediaId`,`houseHistoryId`,`senateHistoryId`,`termStart`,`termEnd`,`senatorClass`,`senatorRank`,`twitter`,`facebook`,`youtube`,`instagram`,`lastUpdated`,`isActive`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: CongressMember) {
        statement.bindText(1, entity.id)
        statement.bindText(2, entity.firstName)
        statement.bindText(3, entity.lastName)
        statement.bindText(4, entity.fullName)
        statement.bindText(5, entity.title)
        statement.bindText(6, entity.party)
        statement.bindText(7, entity.chamber)
        statement.bindText(8, entity.state)
        val _tmpDistrict: String? = entity.district
        if (_tmpDistrict == null) {
          statement.bindNull(9)
        } else {
          statement.bindText(9, _tmpDistrict)
        }
        statement.bindText(10, entity.stateCode)
        statement.bindText(11, entity.phoneNumber)
        statement.bindText(12, entity.email)
        val _tmpWebsite: String? = entity.website
        if (_tmpWebsite == null) {
          statement.bindNull(13)
        } else {
          statement.bindText(13, _tmpWebsite)
        }
        val _tmpOfficeAddress: String? = entity.officeAddress
        if (_tmpOfficeAddress == null) {
          statement.bindNull(14)
        } else {
          statement.bindText(14, _tmpOfficeAddress)
        }
        val _tmpOfficeCity: String? = entity.officeCity
        if (_tmpOfficeCity == null) {
          statement.bindNull(15)
        } else {
          statement.bindText(15, _tmpOfficeCity)
        }
        val _tmpOfficeState: String? = entity.officeState
        if (_tmpOfficeState == null) {
          statement.bindNull(16)
        } else {
          statement.bindText(16, _tmpOfficeState)
        }
        val _tmpOfficeZip: String? = entity.officeZip
        if (_tmpOfficeZip == null) {
          statement.bindNull(17)
        } else {
          statement.bindText(17, _tmpOfficeZip)
        }
        val _tmpOfficeBuilding: String? = entity.officeBuilding
        if (_tmpOfficeBuilding == null) {
          statement.bindNull(18)
        } else {
          statement.bindText(18, _tmpOfficeBuilding)
        }
        val _tmpOfficeRoom: String? = entity.officeRoom
        if (_tmpOfficeRoom == null) {
          statement.bindNull(19)
        } else {
          statement.bindText(19, _tmpOfficeRoom)
        }
        val _tmpBioguideId: String? = entity.bioguideId
        if (_tmpBioguideId == null) {
          statement.bindNull(20)
        } else {
          statement.bindText(20, _tmpBioguideId)
        }
        val _tmpGovtrackId: String? = entity.govtrackId
        if (_tmpGovtrackId == null) {
          statement.bindNull(21)
        } else {
          statement.bindText(21, _tmpGovtrackId)
        }
        val _tmpOpensecretId: String? = entity.opensecretId
        if (_tmpOpensecretId == null) {
          statement.bindNull(22)
        } else {
          statement.bindText(22, _tmpOpensecretId)
        }
        val _tmpVotesmartId: String? = entity.votesmartId
        if (_tmpVotesmartId == null) {
          statement.bindNull(23)
        } else {
          statement.bindText(23, _tmpVotesmartId)
        }
        val _tmpFecId: String? = entity.fecId
        if (_tmpFecId == null) {
          statement.bindNull(24)
        } else {
          statement.bindText(24, _tmpFecId)
        }
        val _tmpCspanId: String? = entity.cspanId
        if (_tmpCspanId == null) {
          statement.bindNull(25)
        } else {
          statement.bindText(25, _tmpCspanId)
        }
        val _tmpWikipediaId: String? = entity.wikipediaId
        if (_tmpWikipediaId == null) {
          statement.bindNull(26)
        } else {
          statement.bindText(26, _tmpWikipediaId)
        }
        val _tmpBallotpediaId: String? = entity.ballotpediaId
        if (_tmpBallotpediaId == null) {
          statement.bindNull(27)
        } else {
          statement.bindText(27, _tmpBallotpediaId)
        }
        val _tmpHouseHistoryId: String? = entity.houseHistoryId
        if (_tmpHouseHistoryId == null) {
          statement.bindNull(28)
        } else {
          statement.bindText(28, _tmpHouseHistoryId)
        }
        val _tmpSenateHistoryId: String? = entity.senateHistoryId
        if (_tmpSenateHistoryId == null) {
          statement.bindNull(29)
        } else {
          statement.bindText(29, _tmpSenateHistoryId)
        }
        val _tmpTermStart: String? = entity.termStart
        if (_tmpTermStart == null) {
          statement.bindNull(30)
        } else {
          statement.bindText(30, _tmpTermStart)
        }
        val _tmpTermEnd: String? = entity.termEnd
        if (_tmpTermEnd == null) {
          statement.bindNull(31)
        } else {
          statement.bindText(31, _tmpTermEnd)
        }
        val _tmpSenatorClass: String? = entity.senatorClass
        if (_tmpSenatorClass == null) {
          statement.bindNull(32)
        } else {
          statement.bindText(32, _tmpSenatorClass)
        }
        val _tmpSenatorRank: String? = entity.senatorRank
        if (_tmpSenatorRank == null) {
          statement.bindNull(33)
        } else {
          statement.bindText(33, _tmpSenatorRank)
        }
        val _tmpTwitter: String? = entity.twitter
        if (_tmpTwitter == null) {
          statement.bindNull(34)
        } else {
          statement.bindText(34, _tmpTwitter)
        }
        val _tmpFacebook: String? = entity.facebook
        if (_tmpFacebook == null) {
          statement.bindNull(35)
        } else {
          statement.bindText(35, _tmpFacebook)
        }
        val _tmpYoutube: String? = entity.youtube
        if (_tmpYoutube == null) {
          statement.bindNull(36)
        } else {
          statement.bindText(36, _tmpYoutube)
        }
        val _tmpInstagram: String? = entity.instagram
        if (_tmpInstagram == null) {
          statement.bindNull(37)
        } else {
          statement.bindText(37, _tmpInstagram)
        }
        statement.bindLong(38, entity.lastUpdated)
        val _tmp: Int = if (entity.isActive) 1 else 0
        statement.bindLong(39, _tmp.toLong())
      }
    }
    this.__deleteAdapterOfCongressMember = object : EntityDeleteOrUpdateAdapter<CongressMember>() {
      protected override fun createQuery(): String = "DELETE FROM `congress_members` WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: CongressMember) {
        statement.bindText(1, entity.id)
      }
    }
    this.__updateAdapterOfCongressMember = object : EntityDeleteOrUpdateAdapter<CongressMember>() {
      protected override fun createQuery(): String = "UPDATE OR ABORT `congress_members` SET `id` = ?,`firstName` = ?,`lastName` = ?,`fullName` = ?,`title` = ?,`party` = ?,`chamber` = ?,`state` = ?,`district` = ?,`stateCode` = ?,`phoneNumber` = ?,`email` = ?,`website` = ?,`officeAddress` = ?,`officeCity` = ?,`officeState` = ?,`officeZip` = ?,`officeBuilding` = ?,`officeRoom` = ?,`bioguideId` = ?,`govtrackId` = ?,`opensecretId` = ?,`votesmartId` = ?,`fecId` = ?,`cspanId` = ?,`wikipediaId` = ?,`ballotpediaId` = ?,`houseHistoryId` = ?,`senateHistoryId` = ?,`termStart` = ?,`termEnd` = ?,`senatorClass` = ?,`senatorRank` = ?,`twitter` = ?,`facebook` = ?,`youtube` = ?,`instagram` = ?,`lastUpdated` = ?,`isActive` = ? WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: CongressMember) {
        statement.bindText(1, entity.id)
        statement.bindText(2, entity.firstName)
        statement.bindText(3, entity.lastName)
        statement.bindText(4, entity.fullName)
        statement.bindText(5, entity.title)
        statement.bindText(6, entity.party)
        statement.bindText(7, entity.chamber)
        statement.bindText(8, entity.state)
        val _tmpDistrict: String? = entity.district
        if (_tmpDistrict == null) {
          statement.bindNull(9)
        } else {
          statement.bindText(9, _tmpDistrict)
        }
        statement.bindText(10, entity.stateCode)
        statement.bindText(11, entity.phoneNumber)
        statement.bindText(12, entity.email)
        val _tmpWebsite: String? = entity.website
        if (_tmpWebsite == null) {
          statement.bindNull(13)
        } else {
          statement.bindText(13, _tmpWebsite)
        }
        val _tmpOfficeAddress: String? = entity.officeAddress
        if (_tmpOfficeAddress == null) {
          statement.bindNull(14)
        } else {
          statement.bindText(14, _tmpOfficeAddress)
        }
        val _tmpOfficeCity: String? = entity.officeCity
        if (_tmpOfficeCity == null) {
          statement.bindNull(15)
        } else {
          statement.bindText(15, _tmpOfficeCity)
        }
        val _tmpOfficeState: String? = entity.officeState
        if (_tmpOfficeState == null) {
          statement.bindNull(16)
        } else {
          statement.bindText(16, _tmpOfficeState)
        }
        val _tmpOfficeZip: String? = entity.officeZip
        if (_tmpOfficeZip == null) {
          statement.bindNull(17)
        } else {
          statement.bindText(17, _tmpOfficeZip)
        }
        val _tmpOfficeBuilding: String? = entity.officeBuilding
        if (_tmpOfficeBuilding == null) {
          statement.bindNull(18)
        } else {
          statement.bindText(18, _tmpOfficeBuilding)
        }
        val _tmpOfficeRoom: String? = entity.officeRoom
        if (_tmpOfficeRoom == null) {
          statement.bindNull(19)
        } else {
          statement.bindText(19, _tmpOfficeRoom)
        }
        val _tmpBioguideId: String? = entity.bioguideId
        if (_tmpBioguideId == null) {
          statement.bindNull(20)
        } else {
          statement.bindText(20, _tmpBioguideId)
        }
        val _tmpGovtrackId: String? = entity.govtrackId
        if (_tmpGovtrackId == null) {
          statement.bindNull(21)
        } else {
          statement.bindText(21, _tmpGovtrackId)
        }
        val _tmpOpensecretId: String? = entity.opensecretId
        if (_tmpOpensecretId == null) {
          statement.bindNull(22)
        } else {
          statement.bindText(22, _tmpOpensecretId)
        }
        val _tmpVotesmartId: String? = entity.votesmartId
        if (_tmpVotesmartId == null) {
          statement.bindNull(23)
        } else {
          statement.bindText(23, _tmpVotesmartId)
        }
        val _tmpFecId: String? = entity.fecId
        if (_tmpFecId == null) {
          statement.bindNull(24)
        } else {
          statement.bindText(24, _tmpFecId)
        }
        val _tmpCspanId: String? = entity.cspanId
        if (_tmpCspanId == null) {
          statement.bindNull(25)
        } else {
          statement.bindText(25, _tmpCspanId)
        }
        val _tmpWikipediaId: String? = entity.wikipediaId
        if (_tmpWikipediaId == null) {
          statement.bindNull(26)
        } else {
          statement.bindText(26, _tmpWikipediaId)
        }
        val _tmpBallotpediaId: String? = entity.ballotpediaId
        if (_tmpBallotpediaId == null) {
          statement.bindNull(27)
        } else {
          statement.bindText(27, _tmpBallotpediaId)
        }
        val _tmpHouseHistoryId: String? = entity.houseHistoryId
        if (_tmpHouseHistoryId == null) {
          statement.bindNull(28)
        } else {
          statement.bindText(28, _tmpHouseHistoryId)
        }
        val _tmpSenateHistoryId: String? = entity.senateHistoryId
        if (_tmpSenateHistoryId == null) {
          statement.bindNull(29)
        } else {
          statement.bindText(29, _tmpSenateHistoryId)
        }
        val _tmpTermStart: String? = entity.termStart
        if (_tmpTermStart == null) {
          statement.bindNull(30)
        } else {
          statement.bindText(30, _tmpTermStart)
        }
        val _tmpTermEnd: String? = entity.termEnd
        if (_tmpTermEnd == null) {
          statement.bindNull(31)
        } else {
          statement.bindText(31, _tmpTermEnd)
        }
        val _tmpSenatorClass: String? = entity.senatorClass
        if (_tmpSenatorClass == null) {
          statement.bindNull(32)
        } else {
          statement.bindText(32, _tmpSenatorClass)
        }
        val _tmpSenatorRank: String? = entity.senatorRank
        if (_tmpSenatorRank == null) {
          statement.bindNull(33)
        } else {
          statement.bindText(33, _tmpSenatorRank)
        }
        val _tmpTwitter: String? = entity.twitter
        if (_tmpTwitter == null) {
          statement.bindNull(34)
        } else {
          statement.bindText(34, _tmpTwitter)
        }
        val _tmpFacebook: String? = entity.facebook
        if (_tmpFacebook == null) {
          statement.bindNull(35)
        } else {
          statement.bindText(35, _tmpFacebook)
        }
        val _tmpYoutube: String? = entity.youtube
        if (_tmpYoutube == null) {
          statement.bindNull(36)
        } else {
          statement.bindText(36, _tmpYoutube)
        }
        val _tmpInstagram: String? = entity.instagram
        if (_tmpInstagram == null) {
          statement.bindNull(37)
        } else {
          statement.bindText(37, _tmpInstagram)
        }
        statement.bindLong(38, entity.lastUpdated)
        val _tmp: Int = if (entity.isActive) 1 else 0
        statement.bindLong(39, _tmp.toLong())
        statement.bindText(40, entity.id)
      }
    }
  }

  public override suspend fun insertMember(member: CongressMember): Unit = performSuspending(__db, false, true) { _connection ->
    __insertAdapterOfCongressMember.insert(_connection, member)
  }

  public override suspend fun insertMembers(members: List<CongressMember>): Unit = performSuspending(__db, false, true) { _connection ->
    __insertAdapterOfCongressMember.insert(_connection, members)
  }

  public override suspend fun deleteMember(member: CongressMember): Unit = performSuspending(__db, false, true) { _connection ->
    __deleteAdapterOfCongressMember.handle(_connection, member)
  }

  public override suspend fun updateMember(member: CongressMember): Unit = performSuspending(__db, false, true) { _connection ->
    __updateAdapterOfCongressMember.handle(_connection, member)
  }

  public override fun getAllMembers(): Flow<List<CongressMember>> {
    val _sql: String = "SELECT * FROM congress_members WHERE isActive = 1 ORDER BY lastName, firstName"
    return createFlow(__db, false, arrayOf("congress_members")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfFirstName: Int = getColumnIndexOrThrow(_stmt, "firstName")
        val _columnIndexOfLastName: Int = getColumnIndexOrThrow(_stmt, "lastName")
        val _columnIndexOfFullName: Int = getColumnIndexOrThrow(_stmt, "fullName")
        val _columnIndexOfTitle: Int = getColumnIndexOrThrow(_stmt, "title")
        val _columnIndexOfParty: Int = getColumnIndexOrThrow(_stmt, "party")
        val _columnIndexOfChamber: Int = getColumnIndexOrThrow(_stmt, "chamber")
        val _columnIndexOfState: Int = getColumnIndexOrThrow(_stmt, "state")
        val _columnIndexOfDistrict: Int = getColumnIndexOrThrow(_stmt, "district")
        val _columnIndexOfStateCode: Int = getColumnIndexOrThrow(_stmt, "stateCode")
        val _columnIndexOfPhoneNumber: Int = getColumnIndexOrThrow(_stmt, "phoneNumber")
        val _columnIndexOfEmail: Int = getColumnIndexOrThrow(_stmt, "email")
        val _columnIndexOfWebsite: Int = getColumnIndexOrThrow(_stmt, "website")
        val _columnIndexOfOfficeAddress: Int = getColumnIndexOrThrow(_stmt, "officeAddress")
        val _columnIndexOfOfficeCity: Int = getColumnIndexOrThrow(_stmt, "officeCity")
        val _columnIndexOfOfficeState: Int = getColumnIndexOrThrow(_stmt, "officeState")
        val _columnIndexOfOfficeZip: Int = getColumnIndexOrThrow(_stmt, "officeZip")
        val _columnIndexOfOfficeBuilding: Int = getColumnIndexOrThrow(_stmt, "officeBuilding")
        val _columnIndexOfOfficeRoom: Int = getColumnIndexOrThrow(_stmt, "officeRoom")
        val _columnIndexOfBioguideId: Int = getColumnIndexOrThrow(_stmt, "bioguideId")
        val _columnIndexOfGovtrackId: Int = getColumnIndexOrThrow(_stmt, "govtrackId")
        val _columnIndexOfOpensecretId: Int = getColumnIndexOrThrow(_stmt, "opensecretId")
        val _columnIndexOfVotesmartId: Int = getColumnIndexOrThrow(_stmt, "votesmartId")
        val _columnIndexOfFecId: Int = getColumnIndexOrThrow(_stmt, "fecId")
        val _columnIndexOfCspanId: Int = getColumnIndexOrThrow(_stmt, "cspanId")
        val _columnIndexOfWikipediaId: Int = getColumnIndexOrThrow(_stmt, "wikipediaId")
        val _columnIndexOfBallotpediaId: Int = getColumnIndexOrThrow(_stmt, "ballotpediaId")
        val _columnIndexOfHouseHistoryId: Int = getColumnIndexOrThrow(_stmt, "houseHistoryId")
        val _columnIndexOfSenateHistoryId: Int = getColumnIndexOrThrow(_stmt, "senateHistoryId")
        val _columnIndexOfTermStart: Int = getColumnIndexOrThrow(_stmt, "termStart")
        val _columnIndexOfTermEnd: Int = getColumnIndexOrThrow(_stmt, "termEnd")
        val _columnIndexOfSenatorClass: Int = getColumnIndexOrThrow(_stmt, "senatorClass")
        val _columnIndexOfSenatorRank: Int = getColumnIndexOrThrow(_stmt, "senatorRank")
        val _columnIndexOfTwitter: Int = getColumnIndexOrThrow(_stmt, "twitter")
        val _columnIndexOfFacebook: Int = getColumnIndexOrThrow(_stmt, "facebook")
        val _columnIndexOfYoutube: Int = getColumnIndexOrThrow(_stmt, "youtube")
        val _columnIndexOfInstagram: Int = getColumnIndexOrThrow(_stmt, "instagram")
        val _columnIndexOfLastUpdated: Int = getColumnIndexOrThrow(_stmt, "lastUpdated")
        val _columnIndexOfIsActive: Int = getColumnIndexOrThrow(_stmt, "isActive")
        val _result: MutableList<CongressMember> = mutableListOf()
        while (_stmt.step()) {
          val _item: CongressMember
          val _tmpId: String
          _tmpId = _stmt.getText(_columnIndexOfId)
          val _tmpFirstName: String
          _tmpFirstName = _stmt.getText(_columnIndexOfFirstName)
          val _tmpLastName: String
          _tmpLastName = _stmt.getText(_columnIndexOfLastName)
          val _tmpFullName: String
          _tmpFullName = _stmt.getText(_columnIndexOfFullName)
          val _tmpTitle: String
          _tmpTitle = _stmt.getText(_columnIndexOfTitle)
          val _tmpParty: String
          _tmpParty = _stmt.getText(_columnIndexOfParty)
          val _tmpChamber: String
          _tmpChamber = _stmt.getText(_columnIndexOfChamber)
          val _tmpState: String
          _tmpState = _stmt.getText(_columnIndexOfState)
          val _tmpDistrict: String?
          if (_stmt.isNull(_columnIndexOfDistrict)) {
            _tmpDistrict = null
          } else {
            _tmpDistrict = _stmt.getText(_columnIndexOfDistrict)
          }
          val _tmpStateCode: String
          _tmpStateCode = _stmt.getText(_columnIndexOfStateCode)
          val _tmpPhoneNumber: String
          _tmpPhoneNumber = _stmt.getText(_columnIndexOfPhoneNumber)
          val _tmpEmail: String
          _tmpEmail = _stmt.getText(_columnIndexOfEmail)
          val _tmpWebsite: String?
          if (_stmt.isNull(_columnIndexOfWebsite)) {
            _tmpWebsite = null
          } else {
            _tmpWebsite = _stmt.getText(_columnIndexOfWebsite)
          }
          val _tmpOfficeAddress: String?
          if (_stmt.isNull(_columnIndexOfOfficeAddress)) {
            _tmpOfficeAddress = null
          } else {
            _tmpOfficeAddress = _stmt.getText(_columnIndexOfOfficeAddress)
          }
          val _tmpOfficeCity: String?
          if (_stmt.isNull(_columnIndexOfOfficeCity)) {
            _tmpOfficeCity = null
          } else {
            _tmpOfficeCity = _stmt.getText(_columnIndexOfOfficeCity)
          }
          val _tmpOfficeState: String?
          if (_stmt.isNull(_columnIndexOfOfficeState)) {
            _tmpOfficeState = null
          } else {
            _tmpOfficeState = _stmt.getText(_columnIndexOfOfficeState)
          }
          val _tmpOfficeZip: String?
          if (_stmt.isNull(_columnIndexOfOfficeZip)) {
            _tmpOfficeZip = null
          } else {
            _tmpOfficeZip = _stmt.getText(_columnIndexOfOfficeZip)
          }
          val _tmpOfficeBuilding: String?
          if (_stmt.isNull(_columnIndexOfOfficeBuilding)) {
            _tmpOfficeBuilding = null
          } else {
            _tmpOfficeBuilding = _stmt.getText(_columnIndexOfOfficeBuilding)
          }
          val _tmpOfficeRoom: String?
          if (_stmt.isNull(_columnIndexOfOfficeRoom)) {
            _tmpOfficeRoom = null
          } else {
            _tmpOfficeRoom = _stmt.getText(_columnIndexOfOfficeRoom)
          }
          val _tmpBioguideId: String?
          if (_stmt.isNull(_columnIndexOfBioguideId)) {
            _tmpBioguideId = null
          } else {
            _tmpBioguideId = _stmt.getText(_columnIndexOfBioguideId)
          }
          val _tmpGovtrackId: String?
          if (_stmt.isNull(_columnIndexOfGovtrackId)) {
            _tmpGovtrackId = null
          } else {
            _tmpGovtrackId = _stmt.getText(_columnIndexOfGovtrackId)
          }
          val _tmpOpensecretId: String?
          if (_stmt.isNull(_columnIndexOfOpensecretId)) {
            _tmpOpensecretId = null
          } else {
            _tmpOpensecretId = _stmt.getText(_columnIndexOfOpensecretId)
          }
          val _tmpVotesmartId: String?
          if (_stmt.isNull(_columnIndexOfVotesmartId)) {
            _tmpVotesmartId = null
          } else {
            _tmpVotesmartId = _stmt.getText(_columnIndexOfVotesmartId)
          }
          val _tmpFecId: String?
          if (_stmt.isNull(_columnIndexOfFecId)) {
            _tmpFecId = null
          } else {
            _tmpFecId = _stmt.getText(_columnIndexOfFecId)
          }
          val _tmpCspanId: String?
          if (_stmt.isNull(_columnIndexOfCspanId)) {
            _tmpCspanId = null
          } else {
            _tmpCspanId = _stmt.getText(_columnIndexOfCspanId)
          }
          val _tmpWikipediaId: String?
          if (_stmt.isNull(_columnIndexOfWikipediaId)) {
            _tmpWikipediaId = null
          } else {
            _tmpWikipediaId = _stmt.getText(_columnIndexOfWikipediaId)
          }
          val _tmpBallotpediaId: String?
          if (_stmt.isNull(_columnIndexOfBallotpediaId)) {
            _tmpBallotpediaId = null
          } else {
            _tmpBallotpediaId = _stmt.getText(_columnIndexOfBallotpediaId)
          }
          val _tmpHouseHistoryId: String?
          if (_stmt.isNull(_columnIndexOfHouseHistoryId)) {
            _tmpHouseHistoryId = null
          } else {
            _tmpHouseHistoryId = _stmt.getText(_columnIndexOfHouseHistoryId)
          }
          val _tmpSenateHistoryId: String?
          if (_stmt.isNull(_columnIndexOfSenateHistoryId)) {
            _tmpSenateHistoryId = null
          } else {
            _tmpSenateHistoryId = _stmt.getText(_columnIndexOfSenateHistoryId)
          }
          val _tmpTermStart: String?
          if (_stmt.isNull(_columnIndexOfTermStart)) {
            _tmpTermStart = null
          } else {
            _tmpTermStart = _stmt.getText(_columnIndexOfTermStart)
          }
          val _tmpTermEnd: String?
          if (_stmt.isNull(_columnIndexOfTermEnd)) {
            _tmpTermEnd = null
          } else {
            _tmpTermEnd = _stmt.getText(_columnIndexOfTermEnd)
          }
          val _tmpSenatorClass: String?
          if (_stmt.isNull(_columnIndexOfSenatorClass)) {
            _tmpSenatorClass = null
          } else {
            _tmpSenatorClass = _stmt.getText(_columnIndexOfSenatorClass)
          }
          val _tmpSenatorRank: String?
          if (_stmt.isNull(_columnIndexOfSenatorRank)) {
            _tmpSenatorRank = null
          } else {
            _tmpSenatorRank = _stmt.getText(_columnIndexOfSenatorRank)
          }
          val _tmpTwitter: String?
          if (_stmt.isNull(_columnIndexOfTwitter)) {
            _tmpTwitter = null
          } else {
            _tmpTwitter = _stmt.getText(_columnIndexOfTwitter)
          }
          val _tmpFacebook: String?
          if (_stmt.isNull(_columnIndexOfFacebook)) {
            _tmpFacebook = null
          } else {
            _tmpFacebook = _stmt.getText(_columnIndexOfFacebook)
          }
          val _tmpYoutube: String?
          if (_stmt.isNull(_columnIndexOfYoutube)) {
            _tmpYoutube = null
          } else {
            _tmpYoutube = _stmt.getText(_columnIndexOfYoutube)
          }
          val _tmpInstagram: String?
          if (_stmt.isNull(_columnIndexOfInstagram)) {
            _tmpInstagram = null
          } else {
            _tmpInstagram = _stmt.getText(_columnIndexOfInstagram)
          }
          val _tmpLastUpdated: Long
          _tmpLastUpdated = _stmt.getLong(_columnIndexOfLastUpdated)
          val _tmpIsActive: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfIsActive).toInt()
          _tmpIsActive = _tmp != 0
          _item = CongressMember(_tmpId,_tmpFirstName,_tmpLastName,_tmpFullName,_tmpTitle,_tmpParty,_tmpChamber,_tmpState,_tmpDistrict,_tmpStateCode,_tmpPhoneNumber,_tmpEmail,_tmpWebsite,_tmpOfficeAddress,_tmpOfficeCity,_tmpOfficeState,_tmpOfficeZip,_tmpOfficeBuilding,_tmpOfficeRoom,_tmpBioguideId,_tmpGovtrackId,_tmpOpensecretId,_tmpVotesmartId,_tmpFecId,_tmpCspanId,_tmpWikipediaId,_tmpBallotpediaId,_tmpHouseHistoryId,_tmpSenateHistoryId,_tmpTermStart,_tmpTermEnd,_tmpSenatorClass,_tmpSenatorRank,_tmpTwitter,_tmpFacebook,_tmpYoutube,_tmpInstagram,_tmpLastUpdated,_tmpIsActive)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getAllMembersList(): List<CongressMember> {
    val _sql: String = "SELECT * FROM congress_members WHERE isActive = 1 ORDER BY lastName, firstName"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfFirstName: Int = getColumnIndexOrThrow(_stmt, "firstName")
        val _columnIndexOfLastName: Int = getColumnIndexOrThrow(_stmt, "lastName")
        val _columnIndexOfFullName: Int = getColumnIndexOrThrow(_stmt, "fullName")
        val _columnIndexOfTitle: Int = getColumnIndexOrThrow(_stmt, "title")
        val _columnIndexOfParty: Int = getColumnIndexOrThrow(_stmt, "party")
        val _columnIndexOfChamber: Int = getColumnIndexOrThrow(_stmt, "chamber")
        val _columnIndexOfState: Int = getColumnIndexOrThrow(_stmt, "state")
        val _columnIndexOfDistrict: Int = getColumnIndexOrThrow(_stmt, "district")
        val _columnIndexOfStateCode: Int = getColumnIndexOrThrow(_stmt, "stateCode")
        val _columnIndexOfPhoneNumber: Int = getColumnIndexOrThrow(_stmt, "phoneNumber")
        val _columnIndexOfEmail: Int = getColumnIndexOrThrow(_stmt, "email")
        val _columnIndexOfWebsite: Int = getColumnIndexOrThrow(_stmt, "website")
        val _columnIndexOfOfficeAddress: Int = getColumnIndexOrThrow(_stmt, "officeAddress")
        val _columnIndexOfOfficeCity: Int = getColumnIndexOrThrow(_stmt, "officeCity")
        val _columnIndexOfOfficeState: Int = getColumnIndexOrThrow(_stmt, "officeState")
        val _columnIndexOfOfficeZip: Int = getColumnIndexOrThrow(_stmt, "officeZip")
        val _columnIndexOfOfficeBuilding: Int = getColumnIndexOrThrow(_stmt, "officeBuilding")
        val _columnIndexOfOfficeRoom: Int = getColumnIndexOrThrow(_stmt, "officeRoom")
        val _columnIndexOfBioguideId: Int = getColumnIndexOrThrow(_stmt, "bioguideId")
        val _columnIndexOfGovtrackId: Int = getColumnIndexOrThrow(_stmt, "govtrackId")
        val _columnIndexOfOpensecretId: Int = getColumnIndexOrThrow(_stmt, "opensecretId")
        val _columnIndexOfVotesmartId: Int = getColumnIndexOrThrow(_stmt, "votesmartId")
        val _columnIndexOfFecId: Int = getColumnIndexOrThrow(_stmt, "fecId")
        val _columnIndexOfCspanId: Int = getColumnIndexOrThrow(_stmt, "cspanId")
        val _columnIndexOfWikipediaId: Int = getColumnIndexOrThrow(_stmt, "wikipediaId")
        val _columnIndexOfBallotpediaId: Int = getColumnIndexOrThrow(_stmt, "ballotpediaId")
        val _columnIndexOfHouseHistoryId: Int = getColumnIndexOrThrow(_stmt, "houseHistoryId")
        val _columnIndexOfSenateHistoryId: Int = getColumnIndexOrThrow(_stmt, "senateHistoryId")
        val _columnIndexOfTermStart: Int = getColumnIndexOrThrow(_stmt, "termStart")
        val _columnIndexOfTermEnd: Int = getColumnIndexOrThrow(_stmt, "termEnd")
        val _columnIndexOfSenatorClass: Int = getColumnIndexOrThrow(_stmt, "senatorClass")
        val _columnIndexOfSenatorRank: Int = getColumnIndexOrThrow(_stmt, "senatorRank")
        val _columnIndexOfTwitter: Int = getColumnIndexOrThrow(_stmt, "twitter")
        val _columnIndexOfFacebook: Int = getColumnIndexOrThrow(_stmt, "facebook")
        val _columnIndexOfYoutube: Int = getColumnIndexOrThrow(_stmt, "youtube")
        val _columnIndexOfInstagram: Int = getColumnIndexOrThrow(_stmt, "instagram")
        val _columnIndexOfLastUpdated: Int = getColumnIndexOrThrow(_stmt, "lastUpdated")
        val _columnIndexOfIsActive: Int = getColumnIndexOrThrow(_stmt, "isActive")
        val _result: MutableList<CongressMember> = mutableListOf()
        while (_stmt.step()) {
          val _item: CongressMember
          val _tmpId: String
          _tmpId = _stmt.getText(_columnIndexOfId)
          val _tmpFirstName: String
          _tmpFirstName = _stmt.getText(_columnIndexOfFirstName)
          val _tmpLastName: String
          _tmpLastName = _stmt.getText(_columnIndexOfLastName)
          val _tmpFullName: String
          _tmpFullName = _stmt.getText(_columnIndexOfFullName)
          val _tmpTitle: String
          _tmpTitle = _stmt.getText(_columnIndexOfTitle)
          val _tmpParty: String
          _tmpParty = _stmt.getText(_columnIndexOfParty)
          val _tmpChamber: String
          _tmpChamber = _stmt.getText(_columnIndexOfChamber)
          val _tmpState: String
          _tmpState = _stmt.getText(_columnIndexOfState)
          val _tmpDistrict: String?
          if (_stmt.isNull(_columnIndexOfDistrict)) {
            _tmpDistrict = null
          } else {
            _tmpDistrict = _stmt.getText(_columnIndexOfDistrict)
          }
          val _tmpStateCode: String
          _tmpStateCode = _stmt.getText(_columnIndexOfStateCode)
          val _tmpPhoneNumber: String
          _tmpPhoneNumber = _stmt.getText(_columnIndexOfPhoneNumber)
          val _tmpEmail: String
          _tmpEmail = _stmt.getText(_columnIndexOfEmail)
          val _tmpWebsite: String?
          if (_stmt.isNull(_columnIndexOfWebsite)) {
            _tmpWebsite = null
          } else {
            _tmpWebsite = _stmt.getText(_columnIndexOfWebsite)
          }
          val _tmpOfficeAddress: String?
          if (_stmt.isNull(_columnIndexOfOfficeAddress)) {
            _tmpOfficeAddress = null
          } else {
            _tmpOfficeAddress = _stmt.getText(_columnIndexOfOfficeAddress)
          }
          val _tmpOfficeCity: String?
          if (_stmt.isNull(_columnIndexOfOfficeCity)) {
            _tmpOfficeCity = null
          } else {
            _tmpOfficeCity = _stmt.getText(_columnIndexOfOfficeCity)
          }
          val _tmpOfficeState: String?
          if (_stmt.isNull(_columnIndexOfOfficeState)) {
            _tmpOfficeState = null
          } else {
            _tmpOfficeState = _stmt.getText(_columnIndexOfOfficeState)
          }
          val _tmpOfficeZip: String?
          if (_stmt.isNull(_columnIndexOfOfficeZip)) {
            _tmpOfficeZip = null
          } else {
            _tmpOfficeZip = _stmt.getText(_columnIndexOfOfficeZip)
          }
          val _tmpOfficeBuilding: String?
          if (_stmt.isNull(_columnIndexOfOfficeBuilding)) {
            _tmpOfficeBuilding = null
          } else {
            _tmpOfficeBuilding = _stmt.getText(_columnIndexOfOfficeBuilding)
          }
          val _tmpOfficeRoom: String?
          if (_stmt.isNull(_columnIndexOfOfficeRoom)) {
            _tmpOfficeRoom = null
          } else {
            _tmpOfficeRoom = _stmt.getText(_columnIndexOfOfficeRoom)
          }
          val _tmpBioguideId: String?
          if (_stmt.isNull(_columnIndexOfBioguideId)) {
            _tmpBioguideId = null
          } else {
            _tmpBioguideId = _stmt.getText(_columnIndexOfBioguideId)
          }
          val _tmpGovtrackId: String?
          if (_stmt.isNull(_columnIndexOfGovtrackId)) {
            _tmpGovtrackId = null
          } else {
            _tmpGovtrackId = _stmt.getText(_columnIndexOfGovtrackId)
          }
          val _tmpOpensecretId: String?
          if (_stmt.isNull(_columnIndexOfOpensecretId)) {
            _tmpOpensecretId = null
          } else {
            _tmpOpensecretId = _stmt.getText(_columnIndexOfOpensecretId)
          }
          val _tmpVotesmartId: String?
          if (_stmt.isNull(_columnIndexOfVotesmartId)) {
            _tmpVotesmartId = null
          } else {
            _tmpVotesmartId = _stmt.getText(_columnIndexOfVotesmartId)
          }
          val _tmpFecId: String?
          if (_stmt.isNull(_columnIndexOfFecId)) {
            _tmpFecId = null
          } else {
            _tmpFecId = _stmt.getText(_columnIndexOfFecId)
          }
          val _tmpCspanId: String?
          if (_stmt.isNull(_columnIndexOfCspanId)) {
            _tmpCspanId = null
          } else {
            _tmpCspanId = _stmt.getText(_columnIndexOfCspanId)
          }
          val _tmpWikipediaId: String?
          if (_stmt.isNull(_columnIndexOfWikipediaId)) {
            _tmpWikipediaId = null
          } else {
            _tmpWikipediaId = _stmt.getText(_columnIndexOfWikipediaId)
          }
          val _tmpBallotpediaId: String?
          if (_stmt.isNull(_columnIndexOfBallotpediaId)) {
            _tmpBallotpediaId = null
          } else {
            _tmpBallotpediaId = _stmt.getText(_columnIndexOfBallotpediaId)
          }
          val _tmpHouseHistoryId: String?
          if (_stmt.isNull(_columnIndexOfHouseHistoryId)) {
            _tmpHouseHistoryId = null
          } else {
            _tmpHouseHistoryId = _stmt.getText(_columnIndexOfHouseHistoryId)
          }
          val _tmpSenateHistoryId: String?
          if (_stmt.isNull(_columnIndexOfSenateHistoryId)) {
            _tmpSenateHistoryId = null
          } else {
            _tmpSenateHistoryId = _stmt.getText(_columnIndexOfSenateHistoryId)
          }
          val _tmpTermStart: String?
          if (_stmt.isNull(_columnIndexOfTermStart)) {
            _tmpTermStart = null
          } else {
            _tmpTermStart = _stmt.getText(_columnIndexOfTermStart)
          }
          val _tmpTermEnd: String?
          if (_stmt.isNull(_columnIndexOfTermEnd)) {
            _tmpTermEnd = null
          } else {
            _tmpTermEnd = _stmt.getText(_columnIndexOfTermEnd)
          }
          val _tmpSenatorClass: String?
          if (_stmt.isNull(_columnIndexOfSenatorClass)) {
            _tmpSenatorClass = null
          } else {
            _tmpSenatorClass = _stmt.getText(_columnIndexOfSenatorClass)
          }
          val _tmpSenatorRank: String?
          if (_stmt.isNull(_columnIndexOfSenatorRank)) {
            _tmpSenatorRank = null
          } else {
            _tmpSenatorRank = _stmt.getText(_columnIndexOfSenatorRank)
          }
          val _tmpTwitter: String?
          if (_stmt.isNull(_columnIndexOfTwitter)) {
            _tmpTwitter = null
          } else {
            _tmpTwitter = _stmt.getText(_columnIndexOfTwitter)
          }
          val _tmpFacebook: String?
          if (_stmt.isNull(_columnIndexOfFacebook)) {
            _tmpFacebook = null
          } else {
            _tmpFacebook = _stmt.getText(_columnIndexOfFacebook)
          }
          val _tmpYoutube: String?
          if (_stmt.isNull(_columnIndexOfYoutube)) {
            _tmpYoutube = null
          } else {
            _tmpYoutube = _stmt.getText(_columnIndexOfYoutube)
          }
          val _tmpInstagram: String?
          if (_stmt.isNull(_columnIndexOfInstagram)) {
            _tmpInstagram = null
          } else {
            _tmpInstagram = _stmt.getText(_columnIndexOfInstagram)
          }
          val _tmpLastUpdated: Long
          _tmpLastUpdated = _stmt.getLong(_columnIndexOfLastUpdated)
          val _tmpIsActive: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfIsActive).toInt()
          _tmpIsActive = _tmp != 0
          _item = CongressMember(_tmpId,_tmpFirstName,_tmpLastName,_tmpFullName,_tmpTitle,_tmpParty,_tmpChamber,_tmpState,_tmpDistrict,_tmpStateCode,_tmpPhoneNumber,_tmpEmail,_tmpWebsite,_tmpOfficeAddress,_tmpOfficeCity,_tmpOfficeState,_tmpOfficeZip,_tmpOfficeBuilding,_tmpOfficeRoom,_tmpBioguideId,_tmpGovtrackId,_tmpOpensecretId,_tmpVotesmartId,_tmpFecId,_tmpCspanId,_tmpWikipediaId,_tmpBallotpediaId,_tmpHouseHistoryId,_tmpSenateHistoryId,_tmpTermStart,_tmpTermEnd,_tmpSenatorClass,_tmpSenatorRank,_tmpTwitter,_tmpFacebook,_tmpYoutube,_tmpInstagram,_tmpLastUpdated,_tmpIsActive)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getMemberById(id: String): CongressMember? {
    val _sql: String = "SELECT * FROM congress_members WHERE id = ?"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, id)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfFirstName: Int = getColumnIndexOrThrow(_stmt, "firstName")
        val _columnIndexOfLastName: Int = getColumnIndexOrThrow(_stmt, "lastName")
        val _columnIndexOfFullName: Int = getColumnIndexOrThrow(_stmt, "fullName")
        val _columnIndexOfTitle: Int = getColumnIndexOrThrow(_stmt, "title")
        val _columnIndexOfParty: Int = getColumnIndexOrThrow(_stmt, "party")
        val _columnIndexOfChamber: Int = getColumnIndexOrThrow(_stmt, "chamber")
        val _columnIndexOfState: Int = getColumnIndexOrThrow(_stmt, "state")
        val _columnIndexOfDistrict: Int = getColumnIndexOrThrow(_stmt, "district")
        val _columnIndexOfStateCode: Int = getColumnIndexOrThrow(_stmt, "stateCode")
        val _columnIndexOfPhoneNumber: Int = getColumnIndexOrThrow(_stmt, "phoneNumber")
        val _columnIndexOfEmail: Int = getColumnIndexOrThrow(_stmt, "email")
        val _columnIndexOfWebsite: Int = getColumnIndexOrThrow(_stmt, "website")
        val _columnIndexOfOfficeAddress: Int = getColumnIndexOrThrow(_stmt, "officeAddress")
        val _columnIndexOfOfficeCity: Int = getColumnIndexOrThrow(_stmt, "officeCity")
        val _columnIndexOfOfficeState: Int = getColumnIndexOrThrow(_stmt, "officeState")
        val _columnIndexOfOfficeZip: Int = getColumnIndexOrThrow(_stmt, "officeZip")
        val _columnIndexOfOfficeBuilding: Int = getColumnIndexOrThrow(_stmt, "officeBuilding")
        val _columnIndexOfOfficeRoom: Int = getColumnIndexOrThrow(_stmt, "officeRoom")
        val _columnIndexOfBioguideId: Int = getColumnIndexOrThrow(_stmt, "bioguideId")
        val _columnIndexOfGovtrackId: Int = getColumnIndexOrThrow(_stmt, "govtrackId")
        val _columnIndexOfOpensecretId: Int = getColumnIndexOrThrow(_stmt, "opensecretId")
        val _columnIndexOfVotesmartId: Int = getColumnIndexOrThrow(_stmt, "votesmartId")
        val _columnIndexOfFecId: Int = getColumnIndexOrThrow(_stmt, "fecId")
        val _columnIndexOfCspanId: Int = getColumnIndexOrThrow(_stmt, "cspanId")
        val _columnIndexOfWikipediaId: Int = getColumnIndexOrThrow(_stmt, "wikipediaId")
        val _columnIndexOfBallotpediaId: Int = getColumnIndexOrThrow(_stmt, "ballotpediaId")
        val _columnIndexOfHouseHistoryId: Int = getColumnIndexOrThrow(_stmt, "houseHistoryId")
        val _columnIndexOfSenateHistoryId: Int = getColumnIndexOrThrow(_stmt, "senateHistoryId")
        val _columnIndexOfTermStart: Int = getColumnIndexOrThrow(_stmt, "termStart")
        val _columnIndexOfTermEnd: Int = getColumnIndexOrThrow(_stmt, "termEnd")
        val _columnIndexOfSenatorClass: Int = getColumnIndexOrThrow(_stmt, "senatorClass")
        val _columnIndexOfSenatorRank: Int = getColumnIndexOrThrow(_stmt, "senatorRank")
        val _columnIndexOfTwitter: Int = getColumnIndexOrThrow(_stmt, "twitter")
        val _columnIndexOfFacebook: Int = getColumnIndexOrThrow(_stmt, "facebook")
        val _columnIndexOfYoutube: Int = getColumnIndexOrThrow(_stmt, "youtube")
        val _columnIndexOfInstagram: Int = getColumnIndexOrThrow(_stmt, "instagram")
        val _columnIndexOfLastUpdated: Int = getColumnIndexOrThrow(_stmt, "lastUpdated")
        val _columnIndexOfIsActive: Int = getColumnIndexOrThrow(_stmt, "isActive")
        val _result: CongressMember?
        if (_stmt.step()) {
          val _tmpId: String
          _tmpId = _stmt.getText(_columnIndexOfId)
          val _tmpFirstName: String
          _tmpFirstName = _stmt.getText(_columnIndexOfFirstName)
          val _tmpLastName: String
          _tmpLastName = _stmt.getText(_columnIndexOfLastName)
          val _tmpFullName: String
          _tmpFullName = _stmt.getText(_columnIndexOfFullName)
          val _tmpTitle: String
          _tmpTitle = _stmt.getText(_columnIndexOfTitle)
          val _tmpParty: String
          _tmpParty = _stmt.getText(_columnIndexOfParty)
          val _tmpChamber: String
          _tmpChamber = _stmt.getText(_columnIndexOfChamber)
          val _tmpState: String
          _tmpState = _stmt.getText(_columnIndexOfState)
          val _tmpDistrict: String?
          if (_stmt.isNull(_columnIndexOfDistrict)) {
            _tmpDistrict = null
          } else {
            _tmpDistrict = _stmt.getText(_columnIndexOfDistrict)
          }
          val _tmpStateCode: String
          _tmpStateCode = _stmt.getText(_columnIndexOfStateCode)
          val _tmpPhoneNumber: String
          _tmpPhoneNumber = _stmt.getText(_columnIndexOfPhoneNumber)
          val _tmpEmail: String
          _tmpEmail = _stmt.getText(_columnIndexOfEmail)
          val _tmpWebsite: String?
          if (_stmt.isNull(_columnIndexOfWebsite)) {
            _tmpWebsite = null
          } else {
            _tmpWebsite = _stmt.getText(_columnIndexOfWebsite)
          }
          val _tmpOfficeAddress: String?
          if (_stmt.isNull(_columnIndexOfOfficeAddress)) {
            _tmpOfficeAddress = null
          } else {
            _tmpOfficeAddress = _stmt.getText(_columnIndexOfOfficeAddress)
          }
          val _tmpOfficeCity: String?
          if (_stmt.isNull(_columnIndexOfOfficeCity)) {
            _tmpOfficeCity = null
          } else {
            _tmpOfficeCity = _stmt.getText(_columnIndexOfOfficeCity)
          }
          val _tmpOfficeState: String?
          if (_stmt.isNull(_columnIndexOfOfficeState)) {
            _tmpOfficeState = null
          } else {
            _tmpOfficeState = _stmt.getText(_columnIndexOfOfficeState)
          }
          val _tmpOfficeZip: String?
          if (_stmt.isNull(_columnIndexOfOfficeZip)) {
            _tmpOfficeZip = null
          } else {
            _tmpOfficeZip = _stmt.getText(_columnIndexOfOfficeZip)
          }
          val _tmpOfficeBuilding: String?
          if (_stmt.isNull(_columnIndexOfOfficeBuilding)) {
            _tmpOfficeBuilding = null
          } else {
            _tmpOfficeBuilding = _stmt.getText(_columnIndexOfOfficeBuilding)
          }
          val _tmpOfficeRoom: String?
          if (_stmt.isNull(_columnIndexOfOfficeRoom)) {
            _tmpOfficeRoom = null
          } else {
            _tmpOfficeRoom = _stmt.getText(_columnIndexOfOfficeRoom)
          }
          val _tmpBioguideId: String?
          if (_stmt.isNull(_columnIndexOfBioguideId)) {
            _tmpBioguideId = null
          } else {
            _tmpBioguideId = _stmt.getText(_columnIndexOfBioguideId)
          }
          val _tmpGovtrackId: String?
          if (_stmt.isNull(_columnIndexOfGovtrackId)) {
            _tmpGovtrackId = null
          } else {
            _tmpGovtrackId = _stmt.getText(_columnIndexOfGovtrackId)
          }
          val _tmpOpensecretId: String?
          if (_stmt.isNull(_columnIndexOfOpensecretId)) {
            _tmpOpensecretId = null
          } else {
            _tmpOpensecretId = _stmt.getText(_columnIndexOfOpensecretId)
          }
          val _tmpVotesmartId: String?
          if (_stmt.isNull(_columnIndexOfVotesmartId)) {
            _tmpVotesmartId = null
          } else {
            _tmpVotesmartId = _stmt.getText(_columnIndexOfVotesmartId)
          }
          val _tmpFecId: String?
          if (_stmt.isNull(_columnIndexOfFecId)) {
            _tmpFecId = null
          } else {
            _tmpFecId = _stmt.getText(_columnIndexOfFecId)
          }
          val _tmpCspanId: String?
          if (_stmt.isNull(_columnIndexOfCspanId)) {
            _tmpCspanId = null
          } else {
            _tmpCspanId = _stmt.getText(_columnIndexOfCspanId)
          }
          val _tmpWikipediaId: String?
          if (_stmt.isNull(_columnIndexOfWikipediaId)) {
            _tmpWikipediaId = null
          } else {
            _tmpWikipediaId = _stmt.getText(_columnIndexOfWikipediaId)
          }
          val _tmpBallotpediaId: String?
          if (_stmt.isNull(_columnIndexOfBallotpediaId)) {
            _tmpBallotpediaId = null
          } else {
            _tmpBallotpediaId = _stmt.getText(_columnIndexOfBallotpediaId)
          }
          val _tmpHouseHistoryId: String?
          if (_stmt.isNull(_columnIndexOfHouseHistoryId)) {
            _tmpHouseHistoryId = null
          } else {
            _tmpHouseHistoryId = _stmt.getText(_columnIndexOfHouseHistoryId)
          }
          val _tmpSenateHistoryId: String?
          if (_stmt.isNull(_columnIndexOfSenateHistoryId)) {
            _tmpSenateHistoryId = null
          } else {
            _tmpSenateHistoryId = _stmt.getText(_columnIndexOfSenateHistoryId)
          }
          val _tmpTermStart: String?
          if (_stmt.isNull(_columnIndexOfTermStart)) {
            _tmpTermStart = null
          } else {
            _tmpTermStart = _stmt.getText(_columnIndexOfTermStart)
          }
          val _tmpTermEnd: String?
          if (_stmt.isNull(_columnIndexOfTermEnd)) {
            _tmpTermEnd = null
          } else {
            _tmpTermEnd = _stmt.getText(_columnIndexOfTermEnd)
          }
          val _tmpSenatorClass: String?
          if (_stmt.isNull(_columnIndexOfSenatorClass)) {
            _tmpSenatorClass = null
          } else {
            _tmpSenatorClass = _stmt.getText(_columnIndexOfSenatorClass)
          }
          val _tmpSenatorRank: String?
          if (_stmt.isNull(_columnIndexOfSenatorRank)) {
            _tmpSenatorRank = null
          } else {
            _tmpSenatorRank = _stmt.getText(_columnIndexOfSenatorRank)
          }
          val _tmpTwitter: String?
          if (_stmt.isNull(_columnIndexOfTwitter)) {
            _tmpTwitter = null
          } else {
            _tmpTwitter = _stmt.getText(_columnIndexOfTwitter)
          }
          val _tmpFacebook: String?
          if (_stmt.isNull(_columnIndexOfFacebook)) {
            _tmpFacebook = null
          } else {
            _tmpFacebook = _stmt.getText(_columnIndexOfFacebook)
          }
          val _tmpYoutube: String?
          if (_stmt.isNull(_columnIndexOfYoutube)) {
            _tmpYoutube = null
          } else {
            _tmpYoutube = _stmt.getText(_columnIndexOfYoutube)
          }
          val _tmpInstagram: String?
          if (_stmt.isNull(_columnIndexOfInstagram)) {
            _tmpInstagram = null
          } else {
            _tmpInstagram = _stmt.getText(_columnIndexOfInstagram)
          }
          val _tmpLastUpdated: Long
          _tmpLastUpdated = _stmt.getLong(_columnIndexOfLastUpdated)
          val _tmpIsActive: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfIsActive).toInt()
          _tmpIsActive = _tmp != 0
          _result = CongressMember(_tmpId,_tmpFirstName,_tmpLastName,_tmpFullName,_tmpTitle,_tmpParty,_tmpChamber,_tmpState,_tmpDistrict,_tmpStateCode,_tmpPhoneNumber,_tmpEmail,_tmpWebsite,_tmpOfficeAddress,_tmpOfficeCity,_tmpOfficeState,_tmpOfficeZip,_tmpOfficeBuilding,_tmpOfficeRoom,_tmpBioguideId,_tmpGovtrackId,_tmpOpensecretId,_tmpVotesmartId,_tmpFecId,_tmpCspanId,_tmpWikipediaId,_tmpBallotpediaId,_tmpHouseHistoryId,_tmpSenateHistoryId,_tmpTermStart,_tmpTermEnd,_tmpSenatorClass,_tmpSenatorRank,_tmpTwitter,_tmpFacebook,_tmpYoutube,_tmpInstagram,_tmpLastUpdated,_tmpIsActive)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun searchMembers(query: String): Flow<List<CongressMember>> {
    val _sql: String = """
        |
        |        SELECT * FROM congress_members 
        |        WHERE isActive = 1 AND (
        |            firstName LIKE '%' || ? || '%' OR
        |            lastName LIKE '%' || ? || '%' OR
        |            fullName LIKE '%' || ? || '%' OR
        |            state LIKE '%' || ? || '%' OR
        |            party LIKE '%' || ? || '%'
        |        )
        |        ORDER BY lastName, firstName
        |    
        """.trimMargin()
    return createFlow(__db, false, arrayOf("congress_members")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, query)
        _argIndex = 2
        _stmt.bindText(_argIndex, query)
        _argIndex = 3
        _stmt.bindText(_argIndex, query)
        _argIndex = 4
        _stmt.bindText(_argIndex, query)
        _argIndex = 5
        _stmt.bindText(_argIndex, query)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfFirstName: Int = getColumnIndexOrThrow(_stmt, "firstName")
        val _columnIndexOfLastName: Int = getColumnIndexOrThrow(_stmt, "lastName")
        val _columnIndexOfFullName: Int = getColumnIndexOrThrow(_stmt, "fullName")
        val _columnIndexOfTitle: Int = getColumnIndexOrThrow(_stmt, "title")
        val _columnIndexOfParty: Int = getColumnIndexOrThrow(_stmt, "party")
        val _columnIndexOfChamber: Int = getColumnIndexOrThrow(_stmt, "chamber")
        val _columnIndexOfState: Int = getColumnIndexOrThrow(_stmt, "state")
        val _columnIndexOfDistrict: Int = getColumnIndexOrThrow(_stmt, "district")
        val _columnIndexOfStateCode: Int = getColumnIndexOrThrow(_stmt, "stateCode")
        val _columnIndexOfPhoneNumber: Int = getColumnIndexOrThrow(_stmt, "phoneNumber")
        val _columnIndexOfEmail: Int = getColumnIndexOrThrow(_stmt, "email")
        val _columnIndexOfWebsite: Int = getColumnIndexOrThrow(_stmt, "website")
        val _columnIndexOfOfficeAddress: Int = getColumnIndexOrThrow(_stmt, "officeAddress")
        val _columnIndexOfOfficeCity: Int = getColumnIndexOrThrow(_stmt, "officeCity")
        val _columnIndexOfOfficeState: Int = getColumnIndexOrThrow(_stmt, "officeState")
        val _columnIndexOfOfficeZip: Int = getColumnIndexOrThrow(_stmt, "officeZip")
        val _columnIndexOfOfficeBuilding: Int = getColumnIndexOrThrow(_stmt, "officeBuilding")
        val _columnIndexOfOfficeRoom: Int = getColumnIndexOrThrow(_stmt, "officeRoom")
        val _columnIndexOfBioguideId: Int = getColumnIndexOrThrow(_stmt, "bioguideId")
        val _columnIndexOfGovtrackId: Int = getColumnIndexOrThrow(_stmt, "govtrackId")
        val _columnIndexOfOpensecretId: Int = getColumnIndexOrThrow(_stmt, "opensecretId")
        val _columnIndexOfVotesmartId: Int = getColumnIndexOrThrow(_stmt, "votesmartId")
        val _columnIndexOfFecId: Int = getColumnIndexOrThrow(_stmt, "fecId")
        val _columnIndexOfCspanId: Int = getColumnIndexOrThrow(_stmt, "cspanId")
        val _columnIndexOfWikipediaId: Int = getColumnIndexOrThrow(_stmt, "wikipediaId")
        val _columnIndexOfBallotpediaId: Int = getColumnIndexOrThrow(_stmt, "ballotpediaId")
        val _columnIndexOfHouseHistoryId: Int = getColumnIndexOrThrow(_stmt, "houseHistoryId")
        val _columnIndexOfSenateHistoryId: Int = getColumnIndexOrThrow(_stmt, "senateHistoryId")
        val _columnIndexOfTermStart: Int = getColumnIndexOrThrow(_stmt, "termStart")
        val _columnIndexOfTermEnd: Int = getColumnIndexOrThrow(_stmt, "termEnd")
        val _columnIndexOfSenatorClass: Int = getColumnIndexOrThrow(_stmt, "senatorClass")
        val _columnIndexOfSenatorRank: Int = getColumnIndexOrThrow(_stmt, "senatorRank")
        val _columnIndexOfTwitter: Int = getColumnIndexOrThrow(_stmt, "twitter")
        val _columnIndexOfFacebook: Int = getColumnIndexOrThrow(_stmt, "facebook")
        val _columnIndexOfYoutube: Int = getColumnIndexOrThrow(_stmt, "youtube")
        val _columnIndexOfInstagram: Int = getColumnIndexOrThrow(_stmt, "instagram")
        val _columnIndexOfLastUpdated: Int = getColumnIndexOrThrow(_stmt, "lastUpdated")
        val _columnIndexOfIsActive: Int = getColumnIndexOrThrow(_stmt, "isActive")
        val _result: MutableList<CongressMember> = mutableListOf()
        while (_stmt.step()) {
          val _item: CongressMember
          val _tmpId: String
          _tmpId = _stmt.getText(_columnIndexOfId)
          val _tmpFirstName: String
          _tmpFirstName = _stmt.getText(_columnIndexOfFirstName)
          val _tmpLastName: String
          _tmpLastName = _stmt.getText(_columnIndexOfLastName)
          val _tmpFullName: String
          _tmpFullName = _stmt.getText(_columnIndexOfFullName)
          val _tmpTitle: String
          _tmpTitle = _stmt.getText(_columnIndexOfTitle)
          val _tmpParty: String
          _tmpParty = _stmt.getText(_columnIndexOfParty)
          val _tmpChamber: String
          _tmpChamber = _stmt.getText(_columnIndexOfChamber)
          val _tmpState: String
          _tmpState = _stmt.getText(_columnIndexOfState)
          val _tmpDistrict: String?
          if (_stmt.isNull(_columnIndexOfDistrict)) {
            _tmpDistrict = null
          } else {
            _tmpDistrict = _stmt.getText(_columnIndexOfDistrict)
          }
          val _tmpStateCode: String
          _tmpStateCode = _stmt.getText(_columnIndexOfStateCode)
          val _tmpPhoneNumber: String
          _tmpPhoneNumber = _stmt.getText(_columnIndexOfPhoneNumber)
          val _tmpEmail: String
          _tmpEmail = _stmt.getText(_columnIndexOfEmail)
          val _tmpWebsite: String?
          if (_stmt.isNull(_columnIndexOfWebsite)) {
            _tmpWebsite = null
          } else {
            _tmpWebsite = _stmt.getText(_columnIndexOfWebsite)
          }
          val _tmpOfficeAddress: String?
          if (_stmt.isNull(_columnIndexOfOfficeAddress)) {
            _tmpOfficeAddress = null
          } else {
            _tmpOfficeAddress = _stmt.getText(_columnIndexOfOfficeAddress)
          }
          val _tmpOfficeCity: String?
          if (_stmt.isNull(_columnIndexOfOfficeCity)) {
            _tmpOfficeCity = null
          } else {
            _tmpOfficeCity = _stmt.getText(_columnIndexOfOfficeCity)
          }
          val _tmpOfficeState: String?
          if (_stmt.isNull(_columnIndexOfOfficeState)) {
            _tmpOfficeState = null
          } else {
            _tmpOfficeState = _stmt.getText(_columnIndexOfOfficeState)
          }
          val _tmpOfficeZip: String?
          if (_stmt.isNull(_columnIndexOfOfficeZip)) {
            _tmpOfficeZip = null
          } else {
            _tmpOfficeZip = _stmt.getText(_columnIndexOfOfficeZip)
          }
          val _tmpOfficeBuilding: String?
          if (_stmt.isNull(_columnIndexOfOfficeBuilding)) {
            _tmpOfficeBuilding = null
          } else {
            _tmpOfficeBuilding = _stmt.getText(_columnIndexOfOfficeBuilding)
          }
          val _tmpOfficeRoom: String?
          if (_stmt.isNull(_columnIndexOfOfficeRoom)) {
            _tmpOfficeRoom = null
          } else {
            _tmpOfficeRoom = _stmt.getText(_columnIndexOfOfficeRoom)
          }
          val _tmpBioguideId: String?
          if (_stmt.isNull(_columnIndexOfBioguideId)) {
            _tmpBioguideId = null
          } else {
            _tmpBioguideId = _stmt.getText(_columnIndexOfBioguideId)
          }
          val _tmpGovtrackId: String?
          if (_stmt.isNull(_columnIndexOfGovtrackId)) {
            _tmpGovtrackId = null
          } else {
            _tmpGovtrackId = _stmt.getText(_columnIndexOfGovtrackId)
          }
          val _tmpOpensecretId: String?
          if (_stmt.isNull(_columnIndexOfOpensecretId)) {
            _tmpOpensecretId = null
          } else {
            _tmpOpensecretId = _stmt.getText(_columnIndexOfOpensecretId)
          }
          val _tmpVotesmartId: String?
          if (_stmt.isNull(_columnIndexOfVotesmartId)) {
            _tmpVotesmartId = null
          } else {
            _tmpVotesmartId = _stmt.getText(_columnIndexOfVotesmartId)
          }
          val _tmpFecId: String?
          if (_stmt.isNull(_columnIndexOfFecId)) {
            _tmpFecId = null
          } else {
            _tmpFecId = _stmt.getText(_columnIndexOfFecId)
          }
          val _tmpCspanId: String?
          if (_stmt.isNull(_columnIndexOfCspanId)) {
            _tmpCspanId = null
          } else {
            _tmpCspanId = _stmt.getText(_columnIndexOfCspanId)
          }
          val _tmpWikipediaId: String?
          if (_stmt.isNull(_columnIndexOfWikipediaId)) {
            _tmpWikipediaId = null
          } else {
            _tmpWikipediaId = _stmt.getText(_columnIndexOfWikipediaId)
          }
          val _tmpBallotpediaId: String?
          if (_stmt.isNull(_columnIndexOfBallotpediaId)) {
            _tmpBallotpediaId = null
          } else {
            _tmpBallotpediaId = _stmt.getText(_columnIndexOfBallotpediaId)
          }
          val _tmpHouseHistoryId: String?
          if (_stmt.isNull(_columnIndexOfHouseHistoryId)) {
            _tmpHouseHistoryId = null
          } else {
            _tmpHouseHistoryId = _stmt.getText(_columnIndexOfHouseHistoryId)
          }
          val _tmpSenateHistoryId: String?
          if (_stmt.isNull(_columnIndexOfSenateHistoryId)) {
            _tmpSenateHistoryId = null
          } else {
            _tmpSenateHistoryId = _stmt.getText(_columnIndexOfSenateHistoryId)
          }
          val _tmpTermStart: String?
          if (_stmt.isNull(_columnIndexOfTermStart)) {
            _tmpTermStart = null
          } else {
            _tmpTermStart = _stmt.getText(_columnIndexOfTermStart)
          }
          val _tmpTermEnd: String?
          if (_stmt.isNull(_columnIndexOfTermEnd)) {
            _tmpTermEnd = null
          } else {
            _tmpTermEnd = _stmt.getText(_columnIndexOfTermEnd)
          }
          val _tmpSenatorClass: String?
          if (_stmt.isNull(_columnIndexOfSenatorClass)) {
            _tmpSenatorClass = null
          } else {
            _tmpSenatorClass = _stmt.getText(_columnIndexOfSenatorClass)
          }
          val _tmpSenatorRank: String?
          if (_stmt.isNull(_columnIndexOfSenatorRank)) {
            _tmpSenatorRank = null
          } else {
            _tmpSenatorRank = _stmt.getText(_columnIndexOfSenatorRank)
          }
          val _tmpTwitter: String?
          if (_stmt.isNull(_columnIndexOfTwitter)) {
            _tmpTwitter = null
          } else {
            _tmpTwitter = _stmt.getText(_columnIndexOfTwitter)
          }
          val _tmpFacebook: String?
          if (_stmt.isNull(_columnIndexOfFacebook)) {
            _tmpFacebook = null
          } else {
            _tmpFacebook = _stmt.getText(_columnIndexOfFacebook)
          }
          val _tmpYoutube: String?
          if (_stmt.isNull(_columnIndexOfYoutube)) {
            _tmpYoutube = null
          } else {
            _tmpYoutube = _stmt.getText(_columnIndexOfYoutube)
          }
          val _tmpInstagram: String?
          if (_stmt.isNull(_columnIndexOfInstagram)) {
            _tmpInstagram = null
          } else {
            _tmpInstagram = _stmt.getText(_columnIndexOfInstagram)
          }
          val _tmpLastUpdated: Long
          _tmpLastUpdated = _stmt.getLong(_columnIndexOfLastUpdated)
          val _tmpIsActive: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfIsActive).toInt()
          _tmpIsActive = _tmp != 0
          _item = CongressMember(_tmpId,_tmpFirstName,_tmpLastName,_tmpFullName,_tmpTitle,_tmpParty,_tmpChamber,_tmpState,_tmpDistrict,_tmpStateCode,_tmpPhoneNumber,_tmpEmail,_tmpWebsite,_tmpOfficeAddress,_tmpOfficeCity,_tmpOfficeState,_tmpOfficeZip,_tmpOfficeBuilding,_tmpOfficeRoom,_tmpBioguideId,_tmpGovtrackId,_tmpOpensecretId,_tmpVotesmartId,_tmpFecId,_tmpCspanId,_tmpWikipediaId,_tmpBallotpediaId,_tmpHouseHistoryId,_tmpSenateHistoryId,_tmpTermStart,_tmpTermEnd,_tmpSenatorClass,_tmpSenatorRank,_tmpTwitter,_tmpFacebook,_tmpYoutube,_tmpInstagram,_tmpLastUpdated,_tmpIsActive)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun getMembersByChamber(chamber: String): Flow<List<CongressMember>> {
    val _sql: String = "SELECT * FROM congress_members WHERE isActive = 1 AND chamber = ? ORDER BY lastName, firstName"
    return createFlow(__db, false, arrayOf("congress_members")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, chamber)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfFirstName: Int = getColumnIndexOrThrow(_stmt, "firstName")
        val _columnIndexOfLastName: Int = getColumnIndexOrThrow(_stmt, "lastName")
        val _columnIndexOfFullName: Int = getColumnIndexOrThrow(_stmt, "fullName")
        val _columnIndexOfTitle: Int = getColumnIndexOrThrow(_stmt, "title")
        val _columnIndexOfParty: Int = getColumnIndexOrThrow(_stmt, "party")
        val _columnIndexOfChamber: Int = getColumnIndexOrThrow(_stmt, "chamber")
        val _columnIndexOfState: Int = getColumnIndexOrThrow(_stmt, "state")
        val _columnIndexOfDistrict: Int = getColumnIndexOrThrow(_stmt, "district")
        val _columnIndexOfStateCode: Int = getColumnIndexOrThrow(_stmt, "stateCode")
        val _columnIndexOfPhoneNumber: Int = getColumnIndexOrThrow(_stmt, "phoneNumber")
        val _columnIndexOfEmail: Int = getColumnIndexOrThrow(_stmt, "email")
        val _columnIndexOfWebsite: Int = getColumnIndexOrThrow(_stmt, "website")
        val _columnIndexOfOfficeAddress: Int = getColumnIndexOrThrow(_stmt, "officeAddress")
        val _columnIndexOfOfficeCity: Int = getColumnIndexOrThrow(_stmt, "officeCity")
        val _columnIndexOfOfficeState: Int = getColumnIndexOrThrow(_stmt, "officeState")
        val _columnIndexOfOfficeZip: Int = getColumnIndexOrThrow(_stmt, "officeZip")
        val _columnIndexOfOfficeBuilding: Int = getColumnIndexOrThrow(_stmt, "officeBuilding")
        val _columnIndexOfOfficeRoom: Int = getColumnIndexOrThrow(_stmt, "officeRoom")
        val _columnIndexOfBioguideId: Int = getColumnIndexOrThrow(_stmt, "bioguideId")
        val _columnIndexOfGovtrackId: Int = getColumnIndexOrThrow(_stmt, "govtrackId")
        val _columnIndexOfOpensecretId: Int = getColumnIndexOrThrow(_stmt, "opensecretId")
        val _columnIndexOfVotesmartId: Int = getColumnIndexOrThrow(_stmt, "votesmartId")
        val _columnIndexOfFecId: Int = getColumnIndexOrThrow(_stmt, "fecId")
        val _columnIndexOfCspanId: Int = getColumnIndexOrThrow(_stmt, "cspanId")
        val _columnIndexOfWikipediaId: Int = getColumnIndexOrThrow(_stmt, "wikipediaId")
        val _columnIndexOfBallotpediaId: Int = getColumnIndexOrThrow(_stmt, "ballotpediaId")
        val _columnIndexOfHouseHistoryId: Int = getColumnIndexOrThrow(_stmt, "houseHistoryId")
        val _columnIndexOfSenateHistoryId: Int = getColumnIndexOrThrow(_stmt, "senateHistoryId")
        val _columnIndexOfTermStart: Int = getColumnIndexOrThrow(_stmt, "termStart")
        val _columnIndexOfTermEnd: Int = getColumnIndexOrThrow(_stmt, "termEnd")
        val _columnIndexOfSenatorClass: Int = getColumnIndexOrThrow(_stmt, "senatorClass")
        val _columnIndexOfSenatorRank: Int = getColumnIndexOrThrow(_stmt, "senatorRank")
        val _columnIndexOfTwitter: Int = getColumnIndexOrThrow(_stmt, "twitter")
        val _columnIndexOfFacebook: Int = getColumnIndexOrThrow(_stmt, "facebook")
        val _columnIndexOfYoutube: Int = getColumnIndexOrThrow(_stmt, "youtube")
        val _columnIndexOfInstagram: Int = getColumnIndexOrThrow(_stmt, "instagram")
        val _columnIndexOfLastUpdated: Int = getColumnIndexOrThrow(_stmt, "lastUpdated")
        val _columnIndexOfIsActive: Int = getColumnIndexOrThrow(_stmt, "isActive")
        val _result: MutableList<CongressMember> = mutableListOf()
        while (_stmt.step()) {
          val _item: CongressMember
          val _tmpId: String
          _tmpId = _stmt.getText(_columnIndexOfId)
          val _tmpFirstName: String
          _tmpFirstName = _stmt.getText(_columnIndexOfFirstName)
          val _tmpLastName: String
          _tmpLastName = _stmt.getText(_columnIndexOfLastName)
          val _tmpFullName: String
          _tmpFullName = _stmt.getText(_columnIndexOfFullName)
          val _tmpTitle: String
          _tmpTitle = _stmt.getText(_columnIndexOfTitle)
          val _tmpParty: String
          _tmpParty = _stmt.getText(_columnIndexOfParty)
          val _tmpChamber: String
          _tmpChamber = _stmt.getText(_columnIndexOfChamber)
          val _tmpState: String
          _tmpState = _stmt.getText(_columnIndexOfState)
          val _tmpDistrict: String?
          if (_stmt.isNull(_columnIndexOfDistrict)) {
            _tmpDistrict = null
          } else {
            _tmpDistrict = _stmt.getText(_columnIndexOfDistrict)
          }
          val _tmpStateCode: String
          _tmpStateCode = _stmt.getText(_columnIndexOfStateCode)
          val _tmpPhoneNumber: String
          _tmpPhoneNumber = _stmt.getText(_columnIndexOfPhoneNumber)
          val _tmpEmail: String
          _tmpEmail = _stmt.getText(_columnIndexOfEmail)
          val _tmpWebsite: String?
          if (_stmt.isNull(_columnIndexOfWebsite)) {
            _tmpWebsite = null
          } else {
            _tmpWebsite = _stmt.getText(_columnIndexOfWebsite)
          }
          val _tmpOfficeAddress: String?
          if (_stmt.isNull(_columnIndexOfOfficeAddress)) {
            _tmpOfficeAddress = null
          } else {
            _tmpOfficeAddress = _stmt.getText(_columnIndexOfOfficeAddress)
          }
          val _tmpOfficeCity: String?
          if (_stmt.isNull(_columnIndexOfOfficeCity)) {
            _tmpOfficeCity = null
          } else {
            _tmpOfficeCity = _stmt.getText(_columnIndexOfOfficeCity)
          }
          val _tmpOfficeState: String?
          if (_stmt.isNull(_columnIndexOfOfficeState)) {
            _tmpOfficeState = null
          } else {
            _tmpOfficeState = _stmt.getText(_columnIndexOfOfficeState)
          }
          val _tmpOfficeZip: String?
          if (_stmt.isNull(_columnIndexOfOfficeZip)) {
            _tmpOfficeZip = null
          } else {
            _tmpOfficeZip = _stmt.getText(_columnIndexOfOfficeZip)
          }
          val _tmpOfficeBuilding: String?
          if (_stmt.isNull(_columnIndexOfOfficeBuilding)) {
            _tmpOfficeBuilding = null
          } else {
            _tmpOfficeBuilding = _stmt.getText(_columnIndexOfOfficeBuilding)
          }
          val _tmpOfficeRoom: String?
          if (_stmt.isNull(_columnIndexOfOfficeRoom)) {
            _tmpOfficeRoom = null
          } else {
            _tmpOfficeRoom = _stmt.getText(_columnIndexOfOfficeRoom)
          }
          val _tmpBioguideId: String?
          if (_stmt.isNull(_columnIndexOfBioguideId)) {
            _tmpBioguideId = null
          } else {
            _tmpBioguideId = _stmt.getText(_columnIndexOfBioguideId)
          }
          val _tmpGovtrackId: String?
          if (_stmt.isNull(_columnIndexOfGovtrackId)) {
            _tmpGovtrackId = null
          } else {
            _tmpGovtrackId = _stmt.getText(_columnIndexOfGovtrackId)
          }
          val _tmpOpensecretId: String?
          if (_stmt.isNull(_columnIndexOfOpensecretId)) {
            _tmpOpensecretId = null
          } else {
            _tmpOpensecretId = _stmt.getText(_columnIndexOfOpensecretId)
          }
          val _tmpVotesmartId: String?
          if (_stmt.isNull(_columnIndexOfVotesmartId)) {
            _tmpVotesmartId = null
          } else {
            _tmpVotesmartId = _stmt.getText(_columnIndexOfVotesmartId)
          }
          val _tmpFecId: String?
          if (_stmt.isNull(_columnIndexOfFecId)) {
            _tmpFecId = null
          } else {
            _tmpFecId = _stmt.getText(_columnIndexOfFecId)
          }
          val _tmpCspanId: String?
          if (_stmt.isNull(_columnIndexOfCspanId)) {
            _tmpCspanId = null
          } else {
            _tmpCspanId = _stmt.getText(_columnIndexOfCspanId)
          }
          val _tmpWikipediaId: String?
          if (_stmt.isNull(_columnIndexOfWikipediaId)) {
            _tmpWikipediaId = null
          } else {
            _tmpWikipediaId = _stmt.getText(_columnIndexOfWikipediaId)
          }
          val _tmpBallotpediaId: String?
          if (_stmt.isNull(_columnIndexOfBallotpediaId)) {
            _tmpBallotpediaId = null
          } else {
            _tmpBallotpediaId = _stmt.getText(_columnIndexOfBallotpediaId)
          }
          val _tmpHouseHistoryId: String?
          if (_stmt.isNull(_columnIndexOfHouseHistoryId)) {
            _tmpHouseHistoryId = null
          } else {
            _tmpHouseHistoryId = _stmt.getText(_columnIndexOfHouseHistoryId)
          }
          val _tmpSenateHistoryId: String?
          if (_stmt.isNull(_columnIndexOfSenateHistoryId)) {
            _tmpSenateHistoryId = null
          } else {
            _tmpSenateHistoryId = _stmt.getText(_columnIndexOfSenateHistoryId)
          }
          val _tmpTermStart: String?
          if (_stmt.isNull(_columnIndexOfTermStart)) {
            _tmpTermStart = null
          } else {
            _tmpTermStart = _stmt.getText(_columnIndexOfTermStart)
          }
          val _tmpTermEnd: String?
          if (_stmt.isNull(_columnIndexOfTermEnd)) {
            _tmpTermEnd = null
          } else {
            _tmpTermEnd = _stmt.getText(_columnIndexOfTermEnd)
          }
          val _tmpSenatorClass: String?
          if (_stmt.isNull(_columnIndexOfSenatorClass)) {
            _tmpSenatorClass = null
          } else {
            _tmpSenatorClass = _stmt.getText(_columnIndexOfSenatorClass)
          }
          val _tmpSenatorRank: String?
          if (_stmt.isNull(_columnIndexOfSenatorRank)) {
            _tmpSenatorRank = null
          } else {
            _tmpSenatorRank = _stmt.getText(_columnIndexOfSenatorRank)
          }
          val _tmpTwitter: String?
          if (_stmt.isNull(_columnIndexOfTwitter)) {
            _tmpTwitter = null
          } else {
            _tmpTwitter = _stmt.getText(_columnIndexOfTwitter)
          }
          val _tmpFacebook: String?
          if (_stmt.isNull(_columnIndexOfFacebook)) {
            _tmpFacebook = null
          } else {
            _tmpFacebook = _stmt.getText(_columnIndexOfFacebook)
          }
          val _tmpYoutube: String?
          if (_stmt.isNull(_columnIndexOfYoutube)) {
            _tmpYoutube = null
          } else {
            _tmpYoutube = _stmt.getText(_columnIndexOfYoutube)
          }
          val _tmpInstagram: String?
          if (_stmt.isNull(_columnIndexOfInstagram)) {
            _tmpInstagram = null
          } else {
            _tmpInstagram = _stmt.getText(_columnIndexOfInstagram)
          }
          val _tmpLastUpdated: Long
          _tmpLastUpdated = _stmt.getLong(_columnIndexOfLastUpdated)
          val _tmpIsActive: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfIsActive).toInt()
          _tmpIsActive = _tmp != 0
          _item = CongressMember(_tmpId,_tmpFirstName,_tmpLastName,_tmpFullName,_tmpTitle,_tmpParty,_tmpChamber,_tmpState,_tmpDistrict,_tmpStateCode,_tmpPhoneNumber,_tmpEmail,_tmpWebsite,_tmpOfficeAddress,_tmpOfficeCity,_tmpOfficeState,_tmpOfficeZip,_tmpOfficeBuilding,_tmpOfficeRoom,_tmpBioguideId,_tmpGovtrackId,_tmpOpensecretId,_tmpVotesmartId,_tmpFecId,_tmpCspanId,_tmpWikipediaId,_tmpBallotpediaId,_tmpHouseHistoryId,_tmpSenateHistoryId,_tmpTermStart,_tmpTermEnd,_tmpSenatorClass,_tmpSenatorRank,_tmpTwitter,_tmpFacebook,_tmpYoutube,_tmpInstagram,_tmpLastUpdated,_tmpIsActive)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun getMembersByParty(party: String): Flow<List<CongressMember>> {
    val _sql: String = "SELECT * FROM congress_members WHERE isActive = 1 AND party = ? ORDER BY lastName, firstName"
    return createFlow(__db, false, arrayOf("congress_members")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, party)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfFirstName: Int = getColumnIndexOrThrow(_stmt, "firstName")
        val _columnIndexOfLastName: Int = getColumnIndexOrThrow(_stmt, "lastName")
        val _columnIndexOfFullName: Int = getColumnIndexOrThrow(_stmt, "fullName")
        val _columnIndexOfTitle: Int = getColumnIndexOrThrow(_stmt, "title")
        val _columnIndexOfParty: Int = getColumnIndexOrThrow(_stmt, "party")
        val _columnIndexOfChamber: Int = getColumnIndexOrThrow(_stmt, "chamber")
        val _columnIndexOfState: Int = getColumnIndexOrThrow(_stmt, "state")
        val _columnIndexOfDistrict: Int = getColumnIndexOrThrow(_stmt, "district")
        val _columnIndexOfStateCode: Int = getColumnIndexOrThrow(_stmt, "stateCode")
        val _columnIndexOfPhoneNumber: Int = getColumnIndexOrThrow(_stmt, "phoneNumber")
        val _columnIndexOfEmail: Int = getColumnIndexOrThrow(_stmt, "email")
        val _columnIndexOfWebsite: Int = getColumnIndexOrThrow(_stmt, "website")
        val _columnIndexOfOfficeAddress: Int = getColumnIndexOrThrow(_stmt, "officeAddress")
        val _columnIndexOfOfficeCity: Int = getColumnIndexOrThrow(_stmt, "officeCity")
        val _columnIndexOfOfficeState: Int = getColumnIndexOrThrow(_stmt, "officeState")
        val _columnIndexOfOfficeZip: Int = getColumnIndexOrThrow(_stmt, "officeZip")
        val _columnIndexOfOfficeBuilding: Int = getColumnIndexOrThrow(_stmt, "officeBuilding")
        val _columnIndexOfOfficeRoom: Int = getColumnIndexOrThrow(_stmt, "officeRoom")
        val _columnIndexOfBioguideId: Int = getColumnIndexOrThrow(_stmt, "bioguideId")
        val _columnIndexOfGovtrackId: Int = getColumnIndexOrThrow(_stmt, "govtrackId")
        val _columnIndexOfOpensecretId: Int = getColumnIndexOrThrow(_stmt, "opensecretId")
        val _columnIndexOfVotesmartId: Int = getColumnIndexOrThrow(_stmt, "votesmartId")
        val _columnIndexOfFecId: Int = getColumnIndexOrThrow(_stmt, "fecId")
        val _columnIndexOfCspanId: Int = getColumnIndexOrThrow(_stmt, "cspanId")
        val _columnIndexOfWikipediaId: Int = getColumnIndexOrThrow(_stmt, "wikipediaId")
        val _columnIndexOfBallotpediaId: Int = getColumnIndexOrThrow(_stmt, "ballotpediaId")
        val _columnIndexOfHouseHistoryId: Int = getColumnIndexOrThrow(_stmt, "houseHistoryId")
        val _columnIndexOfSenateHistoryId: Int = getColumnIndexOrThrow(_stmt, "senateHistoryId")
        val _columnIndexOfTermStart: Int = getColumnIndexOrThrow(_stmt, "termStart")
        val _columnIndexOfTermEnd: Int = getColumnIndexOrThrow(_stmt, "termEnd")
        val _columnIndexOfSenatorClass: Int = getColumnIndexOrThrow(_stmt, "senatorClass")
        val _columnIndexOfSenatorRank: Int = getColumnIndexOrThrow(_stmt, "senatorRank")
        val _columnIndexOfTwitter: Int = getColumnIndexOrThrow(_stmt, "twitter")
        val _columnIndexOfFacebook: Int = getColumnIndexOrThrow(_stmt, "facebook")
        val _columnIndexOfYoutube: Int = getColumnIndexOrThrow(_stmt, "youtube")
        val _columnIndexOfInstagram: Int = getColumnIndexOrThrow(_stmt, "instagram")
        val _columnIndexOfLastUpdated: Int = getColumnIndexOrThrow(_stmt, "lastUpdated")
        val _columnIndexOfIsActive: Int = getColumnIndexOrThrow(_stmt, "isActive")
        val _result: MutableList<CongressMember> = mutableListOf()
        while (_stmt.step()) {
          val _item: CongressMember
          val _tmpId: String
          _tmpId = _stmt.getText(_columnIndexOfId)
          val _tmpFirstName: String
          _tmpFirstName = _stmt.getText(_columnIndexOfFirstName)
          val _tmpLastName: String
          _tmpLastName = _stmt.getText(_columnIndexOfLastName)
          val _tmpFullName: String
          _tmpFullName = _stmt.getText(_columnIndexOfFullName)
          val _tmpTitle: String
          _tmpTitle = _stmt.getText(_columnIndexOfTitle)
          val _tmpParty: String
          _tmpParty = _stmt.getText(_columnIndexOfParty)
          val _tmpChamber: String
          _tmpChamber = _stmt.getText(_columnIndexOfChamber)
          val _tmpState: String
          _tmpState = _stmt.getText(_columnIndexOfState)
          val _tmpDistrict: String?
          if (_stmt.isNull(_columnIndexOfDistrict)) {
            _tmpDistrict = null
          } else {
            _tmpDistrict = _stmt.getText(_columnIndexOfDistrict)
          }
          val _tmpStateCode: String
          _tmpStateCode = _stmt.getText(_columnIndexOfStateCode)
          val _tmpPhoneNumber: String
          _tmpPhoneNumber = _stmt.getText(_columnIndexOfPhoneNumber)
          val _tmpEmail: String
          _tmpEmail = _stmt.getText(_columnIndexOfEmail)
          val _tmpWebsite: String?
          if (_stmt.isNull(_columnIndexOfWebsite)) {
            _tmpWebsite = null
          } else {
            _tmpWebsite = _stmt.getText(_columnIndexOfWebsite)
          }
          val _tmpOfficeAddress: String?
          if (_stmt.isNull(_columnIndexOfOfficeAddress)) {
            _tmpOfficeAddress = null
          } else {
            _tmpOfficeAddress = _stmt.getText(_columnIndexOfOfficeAddress)
          }
          val _tmpOfficeCity: String?
          if (_stmt.isNull(_columnIndexOfOfficeCity)) {
            _tmpOfficeCity = null
          } else {
            _tmpOfficeCity = _stmt.getText(_columnIndexOfOfficeCity)
          }
          val _tmpOfficeState: String?
          if (_stmt.isNull(_columnIndexOfOfficeState)) {
            _tmpOfficeState = null
          } else {
            _tmpOfficeState = _stmt.getText(_columnIndexOfOfficeState)
          }
          val _tmpOfficeZip: String?
          if (_stmt.isNull(_columnIndexOfOfficeZip)) {
            _tmpOfficeZip = null
          } else {
            _tmpOfficeZip = _stmt.getText(_columnIndexOfOfficeZip)
          }
          val _tmpOfficeBuilding: String?
          if (_stmt.isNull(_columnIndexOfOfficeBuilding)) {
            _tmpOfficeBuilding = null
          } else {
            _tmpOfficeBuilding = _stmt.getText(_columnIndexOfOfficeBuilding)
          }
          val _tmpOfficeRoom: String?
          if (_stmt.isNull(_columnIndexOfOfficeRoom)) {
            _tmpOfficeRoom = null
          } else {
            _tmpOfficeRoom = _stmt.getText(_columnIndexOfOfficeRoom)
          }
          val _tmpBioguideId: String?
          if (_stmt.isNull(_columnIndexOfBioguideId)) {
            _tmpBioguideId = null
          } else {
            _tmpBioguideId = _stmt.getText(_columnIndexOfBioguideId)
          }
          val _tmpGovtrackId: String?
          if (_stmt.isNull(_columnIndexOfGovtrackId)) {
            _tmpGovtrackId = null
          } else {
            _tmpGovtrackId = _stmt.getText(_columnIndexOfGovtrackId)
          }
          val _tmpOpensecretId: String?
          if (_stmt.isNull(_columnIndexOfOpensecretId)) {
            _tmpOpensecretId = null
          } else {
            _tmpOpensecretId = _stmt.getText(_columnIndexOfOpensecretId)
          }
          val _tmpVotesmartId: String?
          if (_stmt.isNull(_columnIndexOfVotesmartId)) {
            _tmpVotesmartId = null
          } else {
            _tmpVotesmartId = _stmt.getText(_columnIndexOfVotesmartId)
          }
          val _tmpFecId: String?
          if (_stmt.isNull(_columnIndexOfFecId)) {
            _tmpFecId = null
          } else {
            _tmpFecId = _stmt.getText(_columnIndexOfFecId)
          }
          val _tmpCspanId: String?
          if (_stmt.isNull(_columnIndexOfCspanId)) {
            _tmpCspanId = null
          } else {
            _tmpCspanId = _stmt.getText(_columnIndexOfCspanId)
          }
          val _tmpWikipediaId: String?
          if (_stmt.isNull(_columnIndexOfWikipediaId)) {
            _tmpWikipediaId = null
          } else {
            _tmpWikipediaId = _stmt.getText(_columnIndexOfWikipediaId)
          }
          val _tmpBallotpediaId: String?
          if (_stmt.isNull(_columnIndexOfBallotpediaId)) {
            _tmpBallotpediaId = null
          } else {
            _tmpBallotpediaId = _stmt.getText(_columnIndexOfBallotpediaId)
          }
          val _tmpHouseHistoryId: String?
          if (_stmt.isNull(_columnIndexOfHouseHistoryId)) {
            _tmpHouseHistoryId = null
          } else {
            _tmpHouseHistoryId = _stmt.getText(_columnIndexOfHouseHistoryId)
          }
          val _tmpSenateHistoryId: String?
          if (_stmt.isNull(_columnIndexOfSenateHistoryId)) {
            _tmpSenateHistoryId = null
          } else {
            _tmpSenateHistoryId = _stmt.getText(_columnIndexOfSenateHistoryId)
          }
          val _tmpTermStart: String?
          if (_stmt.isNull(_columnIndexOfTermStart)) {
            _tmpTermStart = null
          } else {
            _tmpTermStart = _stmt.getText(_columnIndexOfTermStart)
          }
          val _tmpTermEnd: String?
          if (_stmt.isNull(_columnIndexOfTermEnd)) {
            _tmpTermEnd = null
          } else {
            _tmpTermEnd = _stmt.getText(_columnIndexOfTermEnd)
          }
          val _tmpSenatorClass: String?
          if (_stmt.isNull(_columnIndexOfSenatorClass)) {
            _tmpSenatorClass = null
          } else {
            _tmpSenatorClass = _stmt.getText(_columnIndexOfSenatorClass)
          }
          val _tmpSenatorRank: String?
          if (_stmt.isNull(_columnIndexOfSenatorRank)) {
            _tmpSenatorRank = null
          } else {
            _tmpSenatorRank = _stmt.getText(_columnIndexOfSenatorRank)
          }
          val _tmpTwitter: String?
          if (_stmt.isNull(_columnIndexOfTwitter)) {
            _tmpTwitter = null
          } else {
            _tmpTwitter = _stmt.getText(_columnIndexOfTwitter)
          }
          val _tmpFacebook: String?
          if (_stmt.isNull(_columnIndexOfFacebook)) {
            _tmpFacebook = null
          } else {
            _tmpFacebook = _stmt.getText(_columnIndexOfFacebook)
          }
          val _tmpYoutube: String?
          if (_stmt.isNull(_columnIndexOfYoutube)) {
            _tmpYoutube = null
          } else {
            _tmpYoutube = _stmt.getText(_columnIndexOfYoutube)
          }
          val _tmpInstagram: String?
          if (_stmt.isNull(_columnIndexOfInstagram)) {
            _tmpInstagram = null
          } else {
            _tmpInstagram = _stmt.getText(_columnIndexOfInstagram)
          }
          val _tmpLastUpdated: Long
          _tmpLastUpdated = _stmt.getLong(_columnIndexOfLastUpdated)
          val _tmpIsActive: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfIsActive).toInt()
          _tmpIsActive = _tmp != 0
          _item = CongressMember(_tmpId,_tmpFirstName,_tmpLastName,_tmpFullName,_tmpTitle,_tmpParty,_tmpChamber,_tmpState,_tmpDistrict,_tmpStateCode,_tmpPhoneNumber,_tmpEmail,_tmpWebsite,_tmpOfficeAddress,_tmpOfficeCity,_tmpOfficeState,_tmpOfficeZip,_tmpOfficeBuilding,_tmpOfficeRoom,_tmpBioguideId,_tmpGovtrackId,_tmpOpensecretId,_tmpVotesmartId,_tmpFecId,_tmpCspanId,_tmpWikipediaId,_tmpBallotpediaId,_tmpHouseHistoryId,_tmpSenateHistoryId,_tmpTermStart,_tmpTermEnd,_tmpSenatorClass,_tmpSenatorRank,_tmpTwitter,_tmpFacebook,_tmpYoutube,_tmpInstagram,_tmpLastUpdated,_tmpIsActive)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun getMembersByState(state: String): Flow<List<CongressMember>> {
    val _sql: String = "SELECT * FROM congress_members WHERE isActive = 1 AND state = ? ORDER BY lastName, firstName"
    return createFlow(__db, false, arrayOf("congress_members")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, state)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfFirstName: Int = getColumnIndexOrThrow(_stmt, "firstName")
        val _columnIndexOfLastName: Int = getColumnIndexOrThrow(_stmt, "lastName")
        val _columnIndexOfFullName: Int = getColumnIndexOrThrow(_stmt, "fullName")
        val _columnIndexOfTitle: Int = getColumnIndexOrThrow(_stmt, "title")
        val _columnIndexOfParty: Int = getColumnIndexOrThrow(_stmt, "party")
        val _columnIndexOfChamber: Int = getColumnIndexOrThrow(_stmt, "chamber")
        val _columnIndexOfState: Int = getColumnIndexOrThrow(_stmt, "state")
        val _columnIndexOfDistrict: Int = getColumnIndexOrThrow(_stmt, "district")
        val _columnIndexOfStateCode: Int = getColumnIndexOrThrow(_stmt, "stateCode")
        val _columnIndexOfPhoneNumber: Int = getColumnIndexOrThrow(_stmt, "phoneNumber")
        val _columnIndexOfEmail: Int = getColumnIndexOrThrow(_stmt, "email")
        val _columnIndexOfWebsite: Int = getColumnIndexOrThrow(_stmt, "website")
        val _columnIndexOfOfficeAddress: Int = getColumnIndexOrThrow(_stmt, "officeAddress")
        val _columnIndexOfOfficeCity: Int = getColumnIndexOrThrow(_stmt, "officeCity")
        val _columnIndexOfOfficeState: Int = getColumnIndexOrThrow(_stmt, "officeState")
        val _columnIndexOfOfficeZip: Int = getColumnIndexOrThrow(_stmt, "officeZip")
        val _columnIndexOfOfficeBuilding: Int = getColumnIndexOrThrow(_stmt, "officeBuilding")
        val _columnIndexOfOfficeRoom: Int = getColumnIndexOrThrow(_stmt, "officeRoom")
        val _columnIndexOfBioguideId: Int = getColumnIndexOrThrow(_stmt, "bioguideId")
        val _columnIndexOfGovtrackId: Int = getColumnIndexOrThrow(_stmt, "govtrackId")
        val _columnIndexOfOpensecretId: Int = getColumnIndexOrThrow(_stmt, "opensecretId")
        val _columnIndexOfVotesmartId: Int = getColumnIndexOrThrow(_stmt, "votesmartId")
        val _columnIndexOfFecId: Int = getColumnIndexOrThrow(_stmt, "fecId")
        val _columnIndexOfCspanId: Int = getColumnIndexOrThrow(_stmt, "cspanId")
        val _columnIndexOfWikipediaId: Int = getColumnIndexOrThrow(_stmt, "wikipediaId")
        val _columnIndexOfBallotpediaId: Int = getColumnIndexOrThrow(_stmt, "ballotpediaId")
        val _columnIndexOfHouseHistoryId: Int = getColumnIndexOrThrow(_stmt, "houseHistoryId")
        val _columnIndexOfSenateHistoryId: Int = getColumnIndexOrThrow(_stmt, "senateHistoryId")
        val _columnIndexOfTermStart: Int = getColumnIndexOrThrow(_stmt, "termStart")
        val _columnIndexOfTermEnd: Int = getColumnIndexOrThrow(_stmt, "termEnd")
        val _columnIndexOfSenatorClass: Int = getColumnIndexOrThrow(_stmt, "senatorClass")
        val _columnIndexOfSenatorRank: Int = getColumnIndexOrThrow(_stmt, "senatorRank")
        val _columnIndexOfTwitter: Int = getColumnIndexOrThrow(_stmt, "twitter")
        val _columnIndexOfFacebook: Int = getColumnIndexOrThrow(_stmt, "facebook")
        val _columnIndexOfYoutube: Int = getColumnIndexOrThrow(_stmt, "youtube")
        val _columnIndexOfInstagram: Int = getColumnIndexOrThrow(_stmt, "instagram")
        val _columnIndexOfLastUpdated: Int = getColumnIndexOrThrow(_stmt, "lastUpdated")
        val _columnIndexOfIsActive: Int = getColumnIndexOrThrow(_stmt, "isActive")
        val _result: MutableList<CongressMember> = mutableListOf()
        while (_stmt.step()) {
          val _item: CongressMember
          val _tmpId: String
          _tmpId = _stmt.getText(_columnIndexOfId)
          val _tmpFirstName: String
          _tmpFirstName = _stmt.getText(_columnIndexOfFirstName)
          val _tmpLastName: String
          _tmpLastName = _stmt.getText(_columnIndexOfLastName)
          val _tmpFullName: String
          _tmpFullName = _stmt.getText(_columnIndexOfFullName)
          val _tmpTitle: String
          _tmpTitle = _stmt.getText(_columnIndexOfTitle)
          val _tmpParty: String
          _tmpParty = _stmt.getText(_columnIndexOfParty)
          val _tmpChamber: String
          _tmpChamber = _stmt.getText(_columnIndexOfChamber)
          val _tmpState: String
          _tmpState = _stmt.getText(_columnIndexOfState)
          val _tmpDistrict: String?
          if (_stmt.isNull(_columnIndexOfDistrict)) {
            _tmpDistrict = null
          } else {
            _tmpDistrict = _stmt.getText(_columnIndexOfDistrict)
          }
          val _tmpStateCode: String
          _tmpStateCode = _stmt.getText(_columnIndexOfStateCode)
          val _tmpPhoneNumber: String
          _tmpPhoneNumber = _stmt.getText(_columnIndexOfPhoneNumber)
          val _tmpEmail: String
          _tmpEmail = _stmt.getText(_columnIndexOfEmail)
          val _tmpWebsite: String?
          if (_stmt.isNull(_columnIndexOfWebsite)) {
            _tmpWebsite = null
          } else {
            _tmpWebsite = _stmt.getText(_columnIndexOfWebsite)
          }
          val _tmpOfficeAddress: String?
          if (_stmt.isNull(_columnIndexOfOfficeAddress)) {
            _tmpOfficeAddress = null
          } else {
            _tmpOfficeAddress = _stmt.getText(_columnIndexOfOfficeAddress)
          }
          val _tmpOfficeCity: String?
          if (_stmt.isNull(_columnIndexOfOfficeCity)) {
            _tmpOfficeCity = null
          } else {
            _tmpOfficeCity = _stmt.getText(_columnIndexOfOfficeCity)
          }
          val _tmpOfficeState: String?
          if (_stmt.isNull(_columnIndexOfOfficeState)) {
            _tmpOfficeState = null
          } else {
            _tmpOfficeState = _stmt.getText(_columnIndexOfOfficeState)
          }
          val _tmpOfficeZip: String?
          if (_stmt.isNull(_columnIndexOfOfficeZip)) {
            _tmpOfficeZip = null
          } else {
            _tmpOfficeZip = _stmt.getText(_columnIndexOfOfficeZip)
          }
          val _tmpOfficeBuilding: String?
          if (_stmt.isNull(_columnIndexOfOfficeBuilding)) {
            _tmpOfficeBuilding = null
          } else {
            _tmpOfficeBuilding = _stmt.getText(_columnIndexOfOfficeBuilding)
          }
          val _tmpOfficeRoom: String?
          if (_stmt.isNull(_columnIndexOfOfficeRoom)) {
            _tmpOfficeRoom = null
          } else {
            _tmpOfficeRoom = _stmt.getText(_columnIndexOfOfficeRoom)
          }
          val _tmpBioguideId: String?
          if (_stmt.isNull(_columnIndexOfBioguideId)) {
            _tmpBioguideId = null
          } else {
            _tmpBioguideId = _stmt.getText(_columnIndexOfBioguideId)
          }
          val _tmpGovtrackId: String?
          if (_stmt.isNull(_columnIndexOfGovtrackId)) {
            _tmpGovtrackId = null
          } else {
            _tmpGovtrackId = _stmt.getText(_columnIndexOfGovtrackId)
          }
          val _tmpOpensecretId: String?
          if (_stmt.isNull(_columnIndexOfOpensecretId)) {
            _tmpOpensecretId = null
          } else {
            _tmpOpensecretId = _stmt.getText(_columnIndexOfOpensecretId)
          }
          val _tmpVotesmartId: String?
          if (_stmt.isNull(_columnIndexOfVotesmartId)) {
            _tmpVotesmartId = null
          } else {
            _tmpVotesmartId = _stmt.getText(_columnIndexOfVotesmartId)
          }
          val _tmpFecId: String?
          if (_stmt.isNull(_columnIndexOfFecId)) {
            _tmpFecId = null
          } else {
            _tmpFecId = _stmt.getText(_columnIndexOfFecId)
          }
          val _tmpCspanId: String?
          if (_stmt.isNull(_columnIndexOfCspanId)) {
            _tmpCspanId = null
          } else {
            _tmpCspanId = _stmt.getText(_columnIndexOfCspanId)
          }
          val _tmpWikipediaId: String?
          if (_stmt.isNull(_columnIndexOfWikipediaId)) {
            _tmpWikipediaId = null
          } else {
            _tmpWikipediaId = _stmt.getText(_columnIndexOfWikipediaId)
          }
          val _tmpBallotpediaId: String?
          if (_stmt.isNull(_columnIndexOfBallotpediaId)) {
            _tmpBallotpediaId = null
          } else {
            _tmpBallotpediaId = _stmt.getText(_columnIndexOfBallotpediaId)
          }
          val _tmpHouseHistoryId: String?
          if (_stmt.isNull(_columnIndexOfHouseHistoryId)) {
            _tmpHouseHistoryId = null
          } else {
            _tmpHouseHistoryId = _stmt.getText(_columnIndexOfHouseHistoryId)
          }
          val _tmpSenateHistoryId: String?
          if (_stmt.isNull(_columnIndexOfSenateHistoryId)) {
            _tmpSenateHistoryId = null
          } else {
            _tmpSenateHistoryId = _stmt.getText(_columnIndexOfSenateHistoryId)
          }
          val _tmpTermStart: String?
          if (_stmt.isNull(_columnIndexOfTermStart)) {
            _tmpTermStart = null
          } else {
            _tmpTermStart = _stmt.getText(_columnIndexOfTermStart)
          }
          val _tmpTermEnd: String?
          if (_stmt.isNull(_columnIndexOfTermEnd)) {
            _tmpTermEnd = null
          } else {
            _tmpTermEnd = _stmt.getText(_columnIndexOfTermEnd)
          }
          val _tmpSenatorClass: String?
          if (_stmt.isNull(_columnIndexOfSenatorClass)) {
            _tmpSenatorClass = null
          } else {
            _tmpSenatorClass = _stmt.getText(_columnIndexOfSenatorClass)
          }
          val _tmpSenatorRank: String?
          if (_stmt.isNull(_columnIndexOfSenatorRank)) {
            _tmpSenatorRank = null
          } else {
            _tmpSenatorRank = _stmt.getText(_columnIndexOfSenatorRank)
          }
          val _tmpTwitter: String?
          if (_stmt.isNull(_columnIndexOfTwitter)) {
            _tmpTwitter = null
          } else {
            _tmpTwitter = _stmt.getText(_columnIndexOfTwitter)
          }
          val _tmpFacebook: String?
          if (_stmt.isNull(_columnIndexOfFacebook)) {
            _tmpFacebook = null
          } else {
            _tmpFacebook = _stmt.getText(_columnIndexOfFacebook)
          }
          val _tmpYoutube: String?
          if (_stmt.isNull(_columnIndexOfYoutube)) {
            _tmpYoutube = null
          } else {
            _tmpYoutube = _stmt.getText(_columnIndexOfYoutube)
          }
          val _tmpInstagram: String?
          if (_stmt.isNull(_columnIndexOfInstagram)) {
            _tmpInstagram = null
          } else {
            _tmpInstagram = _stmt.getText(_columnIndexOfInstagram)
          }
          val _tmpLastUpdated: Long
          _tmpLastUpdated = _stmt.getLong(_columnIndexOfLastUpdated)
          val _tmpIsActive: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfIsActive).toInt()
          _tmpIsActive = _tmp != 0
          _item = CongressMember(_tmpId,_tmpFirstName,_tmpLastName,_tmpFullName,_tmpTitle,_tmpParty,_tmpChamber,_tmpState,_tmpDistrict,_tmpStateCode,_tmpPhoneNumber,_tmpEmail,_tmpWebsite,_tmpOfficeAddress,_tmpOfficeCity,_tmpOfficeState,_tmpOfficeZip,_tmpOfficeBuilding,_tmpOfficeRoom,_tmpBioguideId,_tmpGovtrackId,_tmpOpensecretId,_tmpVotesmartId,_tmpFecId,_tmpCspanId,_tmpWikipediaId,_tmpBallotpediaId,_tmpHouseHistoryId,_tmpSenateHistoryId,_tmpTermStart,_tmpTermEnd,_tmpSenatorClass,_tmpSenatorRank,_tmpTwitter,_tmpFacebook,_tmpYoutube,_tmpInstagram,_tmpLastUpdated,_tmpIsActive)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun getMembersByFilters(
    chamber: String?,
    party: String?,
    state: String?,
  ): Flow<List<CongressMember>> {
    val _sql: String = """
        |
        |        SELECT * FROM congress_members 
        |        WHERE isActive = 1 
        |        AND (? IS NULL OR chamber = ?)
        |        AND (? IS NULL OR party = ?)
        |        AND (? IS NULL OR state = ?)
        |        ORDER BY lastName, firstName
        |    
        """.trimMargin()
    return createFlow(__db, false, arrayOf("congress_members")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        if (chamber == null) {
          _stmt.bindNull(_argIndex)
        } else {
          _stmt.bindText(_argIndex, chamber)
        }
        _argIndex = 2
        if (chamber == null) {
          _stmt.bindNull(_argIndex)
        } else {
          _stmt.bindText(_argIndex, chamber)
        }
        _argIndex = 3
        if (party == null) {
          _stmt.bindNull(_argIndex)
        } else {
          _stmt.bindText(_argIndex, party)
        }
        _argIndex = 4
        if (party == null) {
          _stmt.bindNull(_argIndex)
        } else {
          _stmt.bindText(_argIndex, party)
        }
        _argIndex = 5
        if (state == null) {
          _stmt.bindNull(_argIndex)
        } else {
          _stmt.bindText(_argIndex, state)
        }
        _argIndex = 6
        if (state == null) {
          _stmt.bindNull(_argIndex)
        } else {
          _stmt.bindText(_argIndex, state)
        }
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfFirstName: Int = getColumnIndexOrThrow(_stmt, "firstName")
        val _columnIndexOfLastName: Int = getColumnIndexOrThrow(_stmt, "lastName")
        val _columnIndexOfFullName: Int = getColumnIndexOrThrow(_stmt, "fullName")
        val _columnIndexOfTitle: Int = getColumnIndexOrThrow(_stmt, "title")
        val _columnIndexOfParty: Int = getColumnIndexOrThrow(_stmt, "party")
        val _columnIndexOfChamber: Int = getColumnIndexOrThrow(_stmt, "chamber")
        val _columnIndexOfState: Int = getColumnIndexOrThrow(_stmt, "state")
        val _columnIndexOfDistrict: Int = getColumnIndexOrThrow(_stmt, "district")
        val _columnIndexOfStateCode: Int = getColumnIndexOrThrow(_stmt, "stateCode")
        val _columnIndexOfPhoneNumber: Int = getColumnIndexOrThrow(_stmt, "phoneNumber")
        val _columnIndexOfEmail: Int = getColumnIndexOrThrow(_stmt, "email")
        val _columnIndexOfWebsite: Int = getColumnIndexOrThrow(_stmt, "website")
        val _columnIndexOfOfficeAddress: Int = getColumnIndexOrThrow(_stmt, "officeAddress")
        val _columnIndexOfOfficeCity: Int = getColumnIndexOrThrow(_stmt, "officeCity")
        val _columnIndexOfOfficeState: Int = getColumnIndexOrThrow(_stmt, "officeState")
        val _columnIndexOfOfficeZip: Int = getColumnIndexOrThrow(_stmt, "officeZip")
        val _columnIndexOfOfficeBuilding: Int = getColumnIndexOrThrow(_stmt, "officeBuilding")
        val _columnIndexOfOfficeRoom: Int = getColumnIndexOrThrow(_stmt, "officeRoom")
        val _columnIndexOfBioguideId: Int = getColumnIndexOrThrow(_stmt, "bioguideId")
        val _columnIndexOfGovtrackId: Int = getColumnIndexOrThrow(_stmt, "govtrackId")
        val _columnIndexOfOpensecretId: Int = getColumnIndexOrThrow(_stmt, "opensecretId")
        val _columnIndexOfVotesmartId: Int = getColumnIndexOrThrow(_stmt, "votesmartId")
        val _columnIndexOfFecId: Int = getColumnIndexOrThrow(_stmt, "fecId")
        val _columnIndexOfCspanId: Int = getColumnIndexOrThrow(_stmt, "cspanId")
        val _columnIndexOfWikipediaId: Int = getColumnIndexOrThrow(_stmt, "wikipediaId")
        val _columnIndexOfBallotpediaId: Int = getColumnIndexOrThrow(_stmt, "ballotpediaId")
        val _columnIndexOfHouseHistoryId: Int = getColumnIndexOrThrow(_stmt, "houseHistoryId")
        val _columnIndexOfSenateHistoryId: Int = getColumnIndexOrThrow(_stmt, "senateHistoryId")
        val _columnIndexOfTermStart: Int = getColumnIndexOrThrow(_stmt, "termStart")
        val _columnIndexOfTermEnd: Int = getColumnIndexOrThrow(_stmt, "termEnd")
        val _columnIndexOfSenatorClass: Int = getColumnIndexOrThrow(_stmt, "senatorClass")
        val _columnIndexOfSenatorRank: Int = getColumnIndexOrThrow(_stmt, "senatorRank")
        val _columnIndexOfTwitter: Int = getColumnIndexOrThrow(_stmt, "twitter")
        val _columnIndexOfFacebook: Int = getColumnIndexOrThrow(_stmt, "facebook")
        val _columnIndexOfYoutube: Int = getColumnIndexOrThrow(_stmt, "youtube")
        val _columnIndexOfInstagram: Int = getColumnIndexOrThrow(_stmt, "instagram")
        val _columnIndexOfLastUpdated: Int = getColumnIndexOrThrow(_stmt, "lastUpdated")
        val _columnIndexOfIsActive: Int = getColumnIndexOrThrow(_stmt, "isActive")
        val _result: MutableList<CongressMember> = mutableListOf()
        while (_stmt.step()) {
          val _item: CongressMember
          val _tmpId: String
          _tmpId = _stmt.getText(_columnIndexOfId)
          val _tmpFirstName: String
          _tmpFirstName = _stmt.getText(_columnIndexOfFirstName)
          val _tmpLastName: String
          _tmpLastName = _stmt.getText(_columnIndexOfLastName)
          val _tmpFullName: String
          _tmpFullName = _stmt.getText(_columnIndexOfFullName)
          val _tmpTitle: String
          _tmpTitle = _stmt.getText(_columnIndexOfTitle)
          val _tmpParty: String
          _tmpParty = _stmt.getText(_columnIndexOfParty)
          val _tmpChamber: String
          _tmpChamber = _stmt.getText(_columnIndexOfChamber)
          val _tmpState: String
          _tmpState = _stmt.getText(_columnIndexOfState)
          val _tmpDistrict: String?
          if (_stmt.isNull(_columnIndexOfDistrict)) {
            _tmpDistrict = null
          } else {
            _tmpDistrict = _stmt.getText(_columnIndexOfDistrict)
          }
          val _tmpStateCode: String
          _tmpStateCode = _stmt.getText(_columnIndexOfStateCode)
          val _tmpPhoneNumber: String
          _tmpPhoneNumber = _stmt.getText(_columnIndexOfPhoneNumber)
          val _tmpEmail: String
          _tmpEmail = _stmt.getText(_columnIndexOfEmail)
          val _tmpWebsite: String?
          if (_stmt.isNull(_columnIndexOfWebsite)) {
            _tmpWebsite = null
          } else {
            _tmpWebsite = _stmt.getText(_columnIndexOfWebsite)
          }
          val _tmpOfficeAddress: String?
          if (_stmt.isNull(_columnIndexOfOfficeAddress)) {
            _tmpOfficeAddress = null
          } else {
            _tmpOfficeAddress = _stmt.getText(_columnIndexOfOfficeAddress)
          }
          val _tmpOfficeCity: String?
          if (_stmt.isNull(_columnIndexOfOfficeCity)) {
            _tmpOfficeCity = null
          } else {
            _tmpOfficeCity = _stmt.getText(_columnIndexOfOfficeCity)
          }
          val _tmpOfficeState: String?
          if (_stmt.isNull(_columnIndexOfOfficeState)) {
            _tmpOfficeState = null
          } else {
            _tmpOfficeState = _stmt.getText(_columnIndexOfOfficeState)
          }
          val _tmpOfficeZip: String?
          if (_stmt.isNull(_columnIndexOfOfficeZip)) {
            _tmpOfficeZip = null
          } else {
            _tmpOfficeZip = _stmt.getText(_columnIndexOfOfficeZip)
          }
          val _tmpOfficeBuilding: String?
          if (_stmt.isNull(_columnIndexOfOfficeBuilding)) {
            _tmpOfficeBuilding = null
          } else {
            _tmpOfficeBuilding = _stmt.getText(_columnIndexOfOfficeBuilding)
          }
          val _tmpOfficeRoom: String?
          if (_stmt.isNull(_columnIndexOfOfficeRoom)) {
            _tmpOfficeRoom = null
          } else {
            _tmpOfficeRoom = _stmt.getText(_columnIndexOfOfficeRoom)
          }
          val _tmpBioguideId: String?
          if (_stmt.isNull(_columnIndexOfBioguideId)) {
            _tmpBioguideId = null
          } else {
            _tmpBioguideId = _stmt.getText(_columnIndexOfBioguideId)
          }
          val _tmpGovtrackId: String?
          if (_stmt.isNull(_columnIndexOfGovtrackId)) {
            _tmpGovtrackId = null
          } else {
            _tmpGovtrackId = _stmt.getText(_columnIndexOfGovtrackId)
          }
          val _tmpOpensecretId: String?
          if (_stmt.isNull(_columnIndexOfOpensecretId)) {
            _tmpOpensecretId = null
          } else {
            _tmpOpensecretId = _stmt.getText(_columnIndexOfOpensecretId)
          }
          val _tmpVotesmartId: String?
          if (_stmt.isNull(_columnIndexOfVotesmartId)) {
            _tmpVotesmartId = null
          } else {
            _tmpVotesmartId = _stmt.getText(_columnIndexOfVotesmartId)
          }
          val _tmpFecId: String?
          if (_stmt.isNull(_columnIndexOfFecId)) {
            _tmpFecId = null
          } else {
            _tmpFecId = _stmt.getText(_columnIndexOfFecId)
          }
          val _tmpCspanId: String?
          if (_stmt.isNull(_columnIndexOfCspanId)) {
            _tmpCspanId = null
          } else {
            _tmpCspanId = _stmt.getText(_columnIndexOfCspanId)
          }
          val _tmpWikipediaId: String?
          if (_stmt.isNull(_columnIndexOfWikipediaId)) {
            _tmpWikipediaId = null
          } else {
            _tmpWikipediaId = _stmt.getText(_columnIndexOfWikipediaId)
          }
          val _tmpBallotpediaId: String?
          if (_stmt.isNull(_columnIndexOfBallotpediaId)) {
            _tmpBallotpediaId = null
          } else {
            _tmpBallotpediaId = _stmt.getText(_columnIndexOfBallotpediaId)
          }
          val _tmpHouseHistoryId: String?
          if (_stmt.isNull(_columnIndexOfHouseHistoryId)) {
            _tmpHouseHistoryId = null
          } else {
            _tmpHouseHistoryId = _stmt.getText(_columnIndexOfHouseHistoryId)
          }
          val _tmpSenateHistoryId: String?
          if (_stmt.isNull(_columnIndexOfSenateHistoryId)) {
            _tmpSenateHistoryId = null
          } else {
            _tmpSenateHistoryId = _stmt.getText(_columnIndexOfSenateHistoryId)
          }
          val _tmpTermStart: String?
          if (_stmt.isNull(_columnIndexOfTermStart)) {
            _tmpTermStart = null
          } else {
            _tmpTermStart = _stmt.getText(_columnIndexOfTermStart)
          }
          val _tmpTermEnd: String?
          if (_stmt.isNull(_columnIndexOfTermEnd)) {
            _tmpTermEnd = null
          } else {
            _tmpTermEnd = _stmt.getText(_columnIndexOfTermEnd)
          }
          val _tmpSenatorClass: String?
          if (_stmt.isNull(_columnIndexOfSenatorClass)) {
            _tmpSenatorClass = null
          } else {
            _tmpSenatorClass = _stmt.getText(_columnIndexOfSenatorClass)
          }
          val _tmpSenatorRank: String?
          if (_stmt.isNull(_columnIndexOfSenatorRank)) {
            _tmpSenatorRank = null
          } else {
            _tmpSenatorRank = _stmt.getText(_columnIndexOfSenatorRank)
          }
          val _tmpTwitter: String?
          if (_stmt.isNull(_columnIndexOfTwitter)) {
            _tmpTwitter = null
          } else {
            _tmpTwitter = _stmt.getText(_columnIndexOfTwitter)
          }
          val _tmpFacebook: String?
          if (_stmt.isNull(_columnIndexOfFacebook)) {
            _tmpFacebook = null
          } else {
            _tmpFacebook = _stmt.getText(_columnIndexOfFacebook)
          }
          val _tmpYoutube: String?
          if (_stmt.isNull(_columnIndexOfYoutube)) {
            _tmpYoutube = null
          } else {
            _tmpYoutube = _stmt.getText(_columnIndexOfYoutube)
          }
          val _tmpInstagram: String?
          if (_stmt.isNull(_columnIndexOfInstagram)) {
            _tmpInstagram = null
          } else {
            _tmpInstagram = _stmt.getText(_columnIndexOfInstagram)
          }
          val _tmpLastUpdated: Long
          _tmpLastUpdated = _stmt.getLong(_columnIndexOfLastUpdated)
          val _tmpIsActive: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfIsActive).toInt()
          _tmpIsActive = _tmp != 0
          _item = CongressMember(_tmpId,_tmpFirstName,_tmpLastName,_tmpFullName,_tmpTitle,_tmpParty,_tmpChamber,_tmpState,_tmpDistrict,_tmpStateCode,_tmpPhoneNumber,_tmpEmail,_tmpWebsite,_tmpOfficeAddress,_tmpOfficeCity,_tmpOfficeState,_tmpOfficeZip,_tmpOfficeBuilding,_tmpOfficeRoom,_tmpBioguideId,_tmpGovtrackId,_tmpOpensecretId,_tmpVotesmartId,_tmpFecId,_tmpCspanId,_tmpWikipediaId,_tmpBallotpediaId,_tmpHouseHistoryId,_tmpSenateHistoryId,_tmpTermStart,_tmpTermEnd,_tmpSenatorClass,_tmpSenatorRank,_tmpTwitter,_tmpFacebook,_tmpYoutube,_tmpInstagram,_tmpLastUpdated,_tmpIsActive)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getAllEmailAddresses(): List<String> {
    val _sql: String = "SELECT email FROM congress_members WHERE isActive = 1 AND email != ''"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _result: MutableList<String> = mutableListOf()
        while (_stmt.step()) {
          val _item: String
          _item = _stmt.getText(0)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getAllPhoneNumbers(): List<String> {
    val _sql: String = "SELECT phoneNumber FROM congress_members WHERE isActive = 1 AND phoneNumber != ''"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _result: MutableList<String> = mutableListOf()
        while (_stmt.step()) {
          val _item: String
          _item = _stmt.getText(0)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getMembersWithEmail(): List<CongressMember> {
    val _sql: String = "SELECT * FROM congress_members WHERE isActive = 1 AND email != '' ORDER BY lastName, firstName"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfFirstName: Int = getColumnIndexOrThrow(_stmt, "firstName")
        val _columnIndexOfLastName: Int = getColumnIndexOrThrow(_stmt, "lastName")
        val _columnIndexOfFullName: Int = getColumnIndexOrThrow(_stmt, "fullName")
        val _columnIndexOfTitle: Int = getColumnIndexOrThrow(_stmt, "title")
        val _columnIndexOfParty: Int = getColumnIndexOrThrow(_stmt, "party")
        val _columnIndexOfChamber: Int = getColumnIndexOrThrow(_stmt, "chamber")
        val _columnIndexOfState: Int = getColumnIndexOrThrow(_stmt, "state")
        val _columnIndexOfDistrict: Int = getColumnIndexOrThrow(_stmt, "district")
        val _columnIndexOfStateCode: Int = getColumnIndexOrThrow(_stmt, "stateCode")
        val _columnIndexOfPhoneNumber: Int = getColumnIndexOrThrow(_stmt, "phoneNumber")
        val _columnIndexOfEmail: Int = getColumnIndexOrThrow(_stmt, "email")
        val _columnIndexOfWebsite: Int = getColumnIndexOrThrow(_stmt, "website")
        val _columnIndexOfOfficeAddress: Int = getColumnIndexOrThrow(_stmt, "officeAddress")
        val _columnIndexOfOfficeCity: Int = getColumnIndexOrThrow(_stmt, "officeCity")
        val _columnIndexOfOfficeState: Int = getColumnIndexOrThrow(_stmt, "officeState")
        val _columnIndexOfOfficeZip: Int = getColumnIndexOrThrow(_stmt, "officeZip")
        val _columnIndexOfOfficeBuilding: Int = getColumnIndexOrThrow(_stmt, "officeBuilding")
        val _columnIndexOfOfficeRoom: Int = getColumnIndexOrThrow(_stmt, "officeRoom")
        val _columnIndexOfBioguideId: Int = getColumnIndexOrThrow(_stmt, "bioguideId")
        val _columnIndexOfGovtrackId: Int = getColumnIndexOrThrow(_stmt, "govtrackId")
        val _columnIndexOfOpensecretId: Int = getColumnIndexOrThrow(_stmt, "opensecretId")
        val _columnIndexOfVotesmartId: Int = getColumnIndexOrThrow(_stmt, "votesmartId")
        val _columnIndexOfFecId: Int = getColumnIndexOrThrow(_stmt, "fecId")
        val _columnIndexOfCspanId: Int = getColumnIndexOrThrow(_stmt, "cspanId")
        val _columnIndexOfWikipediaId: Int = getColumnIndexOrThrow(_stmt, "wikipediaId")
        val _columnIndexOfBallotpediaId: Int = getColumnIndexOrThrow(_stmt, "ballotpediaId")
        val _columnIndexOfHouseHistoryId: Int = getColumnIndexOrThrow(_stmt, "houseHistoryId")
        val _columnIndexOfSenateHistoryId: Int = getColumnIndexOrThrow(_stmt, "senateHistoryId")
        val _columnIndexOfTermStart: Int = getColumnIndexOrThrow(_stmt, "termStart")
        val _columnIndexOfTermEnd: Int = getColumnIndexOrThrow(_stmt, "termEnd")
        val _columnIndexOfSenatorClass: Int = getColumnIndexOrThrow(_stmt, "senatorClass")
        val _columnIndexOfSenatorRank: Int = getColumnIndexOrThrow(_stmt, "senatorRank")
        val _columnIndexOfTwitter: Int = getColumnIndexOrThrow(_stmt, "twitter")
        val _columnIndexOfFacebook: Int = getColumnIndexOrThrow(_stmt, "facebook")
        val _columnIndexOfYoutube: Int = getColumnIndexOrThrow(_stmt, "youtube")
        val _columnIndexOfInstagram: Int = getColumnIndexOrThrow(_stmt, "instagram")
        val _columnIndexOfLastUpdated: Int = getColumnIndexOrThrow(_stmt, "lastUpdated")
        val _columnIndexOfIsActive: Int = getColumnIndexOrThrow(_stmt, "isActive")
        val _result: MutableList<CongressMember> = mutableListOf()
        while (_stmt.step()) {
          val _item: CongressMember
          val _tmpId: String
          _tmpId = _stmt.getText(_columnIndexOfId)
          val _tmpFirstName: String
          _tmpFirstName = _stmt.getText(_columnIndexOfFirstName)
          val _tmpLastName: String
          _tmpLastName = _stmt.getText(_columnIndexOfLastName)
          val _tmpFullName: String
          _tmpFullName = _stmt.getText(_columnIndexOfFullName)
          val _tmpTitle: String
          _tmpTitle = _stmt.getText(_columnIndexOfTitle)
          val _tmpParty: String
          _tmpParty = _stmt.getText(_columnIndexOfParty)
          val _tmpChamber: String
          _tmpChamber = _stmt.getText(_columnIndexOfChamber)
          val _tmpState: String
          _tmpState = _stmt.getText(_columnIndexOfState)
          val _tmpDistrict: String?
          if (_stmt.isNull(_columnIndexOfDistrict)) {
            _tmpDistrict = null
          } else {
            _tmpDistrict = _stmt.getText(_columnIndexOfDistrict)
          }
          val _tmpStateCode: String
          _tmpStateCode = _stmt.getText(_columnIndexOfStateCode)
          val _tmpPhoneNumber: String
          _tmpPhoneNumber = _stmt.getText(_columnIndexOfPhoneNumber)
          val _tmpEmail: String
          _tmpEmail = _stmt.getText(_columnIndexOfEmail)
          val _tmpWebsite: String?
          if (_stmt.isNull(_columnIndexOfWebsite)) {
            _tmpWebsite = null
          } else {
            _tmpWebsite = _stmt.getText(_columnIndexOfWebsite)
          }
          val _tmpOfficeAddress: String?
          if (_stmt.isNull(_columnIndexOfOfficeAddress)) {
            _tmpOfficeAddress = null
          } else {
            _tmpOfficeAddress = _stmt.getText(_columnIndexOfOfficeAddress)
          }
          val _tmpOfficeCity: String?
          if (_stmt.isNull(_columnIndexOfOfficeCity)) {
            _tmpOfficeCity = null
          } else {
            _tmpOfficeCity = _stmt.getText(_columnIndexOfOfficeCity)
          }
          val _tmpOfficeState: String?
          if (_stmt.isNull(_columnIndexOfOfficeState)) {
            _tmpOfficeState = null
          } else {
            _tmpOfficeState = _stmt.getText(_columnIndexOfOfficeState)
          }
          val _tmpOfficeZip: String?
          if (_stmt.isNull(_columnIndexOfOfficeZip)) {
            _tmpOfficeZip = null
          } else {
            _tmpOfficeZip = _stmt.getText(_columnIndexOfOfficeZip)
          }
          val _tmpOfficeBuilding: String?
          if (_stmt.isNull(_columnIndexOfOfficeBuilding)) {
            _tmpOfficeBuilding = null
          } else {
            _tmpOfficeBuilding = _stmt.getText(_columnIndexOfOfficeBuilding)
          }
          val _tmpOfficeRoom: String?
          if (_stmt.isNull(_columnIndexOfOfficeRoom)) {
            _tmpOfficeRoom = null
          } else {
            _tmpOfficeRoom = _stmt.getText(_columnIndexOfOfficeRoom)
          }
          val _tmpBioguideId: String?
          if (_stmt.isNull(_columnIndexOfBioguideId)) {
            _tmpBioguideId = null
          } else {
            _tmpBioguideId = _stmt.getText(_columnIndexOfBioguideId)
          }
          val _tmpGovtrackId: String?
          if (_stmt.isNull(_columnIndexOfGovtrackId)) {
            _tmpGovtrackId = null
          } else {
            _tmpGovtrackId = _stmt.getText(_columnIndexOfGovtrackId)
          }
          val _tmpOpensecretId: String?
          if (_stmt.isNull(_columnIndexOfOpensecretId)) {
            _tmpOpensecretId = null
          } else {
            _tmpOpensecretId = _stmt.getText(_columnIndexOfOpensecretId)
          }
          val _tmpVotesmartId: String?
          if (_stmt.isNull(_columnIndexOfVotesmartId)) {
            _tmpVotesmartId = null
          } else {
            _tmpVotesmartId = _stmt.getText(_columnIndexOfVotesmartId)
          }
          val _tmpFecId: String?
          if (_stmt.isNull(_columnIndexOfFecId)) {
            _tmpFecId = null
          } else {
            _tmpFecId = _stmt.getText(_columnIndexOfFecId)
          }
          val _tmpCspanId: String?
          if (_stmt.isNull(_columnIndexOfCspanId)) {
            _tmpCspanId = null
          } else {
            _tmpCspanId = _stmt.getText(_columnIndexOfCspanId)
          }
          val _tmpWikipediaId: String?
          if (_stmt.isNull(_columnIndexOfWikipediaId)) {
            _tmpWikipediaId = null
          } else {
            _tmpWikipediaId = _stmt.getText(_columnIndexOfWikipediaId)
          }
          val _tmpBallotpediaId: String?
          if (_stmt.isNull(_columnIndexOfBallotpediaId)) {
            _tmpBallotpediaId = null
          } else {
            _tmpBallotpediaId = _stmt.getText(_columnIndexOfBallotpediaId)
          }
          val _tmpHouseHistoryId: String?
          if (_stmt.isNull(_columnIndexOfHouseHistoryId)) {
            _tmpHouseHistoryId = null
          } else {
            _tmpHouseHistoryId = _stmt.getText(_columnIndexOfHouseHistoryId)
          }
          val _tmpSenateHistoryId: String?
          if (_stmt.isNull(_columnIndexOfSenateHistoryId)) {
            _tmpSenateHistoryId = null
          } else {
            _tmpSenateHistoryId = _stmt.getText(_columnIndexOfSenateHistoryId)
          }
          val _tmpTermStart: String?
          if (_stmt.isNull(_columnIndexOfTermStart)) {
            _tmpTermStart = null
          } else {
            _tmpTermStart = _stmt.getText(_columnIndexOfTermStart)
          }
          val _tmpTermEnd: String?
          if (_stmt.isNull(_columnIndexOfTermEnd)) {
            _tmpTermEnd = null
          } else {
            _tmpTermEnd = _stmt.getText(_columnIndexOfTermEnd)
          }
          val _tmpSenatorClass: String?
          if (_stmt.isNull(_columnIndexOfSenatorClass)) {
            _tmpSenatorClass = null
          } else {
            _tmpSenatorClass = _stmt.getText(_columnIndexOfSenatorClass)
          }
          val _tmpSenatorRank: String?
          if (_stmt.isNull(_columnIndexOfSenatorRank)) {
            _tmpSenatorRank = null
          } else {
            _tmpSenatorRank = _stmt.getText(_columnIndexOfSenatorRank)
          }
          val _tmpTwitter: String?
          if (_stmt.isNull(_columnIndexOfTwitter)) {
            _tmpTwitter = null
          } else {
            _tmpTwitter = _stmt.getText(_columnIndexOfTwitter)
          }
          val _tmpFacebook: String?
          if (_stmt.isNull(_columnIndexOfFacebook)) {
            _tmpFacebook = null
          } else {
            _tmpFacebook = _stmt.getText(_columnIndexOfFacebook)
          }
          val _tmpYoutube: String?
          if (_stmt.isNull(_columnIndexOfYoutube)) {
            _tmpYoutube = null
          } else {
            _tmpYoutube = _stmt.getText(_columnIndexOfYoutube)
          }
          val _tmpInstagram: String?
          if (_stmt.isNull(_columnIndexOfInstagram)) {
            _tmpInstagram = null
          } else {
            _tmpInstagram = _stmt.getText(_columnIndexOfInstagram)
          }
          val _tmpLastUpdated: Long
          _tmpLastUpdated = _stmt.getLong(_columnIndexOfLastUpdated)
          val _tmpIsActive: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfIsActive).toInt()
          _tmpIsActive = _tmp != 0
          _item = CongressMember(_tmpId,_tmpFirstName,_tmpLastName,_tmpFullName,_tmpTitle,_tmpParty,_tmpChamber,_tmpState,_tmpDistrict,_tmpStateCode,_tmpPhoneNumber,_tmpEmail,_tmpWebsite,_tmpOfficeAddress,_tmpOfficeCity,_tmpOfficeState,_tmpOfficeZip,_tmpOfficeBuilding,_tmpOfficeRoom,_tmpBioguideId,_tmpGovtrackId,_tmpOpensecretId,_tmpVotesmartId,_tmpFecId,_tmpCspanId,_tmpWikipediaId,_tmpBallotpediaId,_tmpHouseHistoryId,_tmpSenateHistoryId,_tmpTermStart,_tmpTermEnd,_tmpSenatorClass,_tmpSenatorRank,_tmpTwitter,_tmpFacebook,_tmpYoutube,_tmpInstagram,_tmpLastUpdated,_tmpIsActive)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getMembersWithPhone(): List<CongressMember> {
    val _sql: String = "SELECT * FROM congress_members WHERE isActive = 1 AND phoneNumber != '' ORDER BY lastName, firstName"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfFirstName: Int = getColumnIndexOrThrow(_stmt, "firstName")
        val _columnIndexOfLastName: Int = getColumnIndexOrThrow(_stmt, "lastName")
        val _columnIndexOfFullName: Int = getColumnIndexOrThrow(_stmt, "fullName")
        val _columnIndexOfTitle: Int = getColumnIndexOrThrow(_stmt, "title")
        val _columnIndexOfParty: Int = getColumnIndexOrThrow(_stmt, "party")
        val _columnIndexOfChamber: Int = getColumnIndexOrThrow(_stmt, "chamber")
        val _columnIndexOfState: Int = getColumnIndexOrThrow(_stmt, "state")
        val _columnIndexOfDistrict: Int = getColumnIndexOrThrow(_stmt, "district")
        val _columnIndexOfStateCode: Int = getColumnIndexOrThrow(_stmt, "stateCode")
        val _columnIndexOfPhoneNumber: Int = getColumnIndexOrThrow(_stmt, "phoneNumber")
        val _columnIndexOfEmail: Int = getColumnIndexOrThrow(_stmt, "email")
        val _columnIndexOfWebsite: Int = getColumnIndexOrThrow(_stmt, "website")
        val _columnIndexOfOfficeAddress: Int = getColumnIndexOrThrow(_stmt, "officeAddress")
        val _columnIndexOfOfficeCity: Int = getColumnIndexOrThrow(_stmt, "officeCity")
        val _columnIndexOfOfficeState: Int = getColumnIndexOrThrow(_stmt, "officeState")
        val _columnIndexOfOfficeZip: Int = getColumnIndexOrThrow(_stmt, "officeZip")
        val _columnIndexOfOfficeBuilding: Int = getColumnIndexOrThrow(_stmt, "officeBuilding")
        val _columnIndexOfOfficeRoom: Int = getColumnIndexOrThrow(_stmt, "officeRoom")
        val _columnIndexOfBioguideId: Int = getColumnIndexOrThrow(_stmt, "bioguideId")
        val _columnIndexOfGovtrackId: Int = getColumnIndexOrThrow(_stmt, "govtrackId")
        val _columnIndexOfOpensecretId: Int = getColumnIndexOrThrow(_stmt, "opensecretId")
        val _columnIndexOfVotesmartId: Int = getColumnIndexOrThrow(_stmt, "votesmartId")
        val _columnIndexOfFecId: Int = getColumnIndexOrThrow(_stmt, "fecId")
        val _columnIndexOfCspanId: Int = getColumnIndexOrThrow(_stmt, "cspanId")
        val _columnIndexOfWikipediaId: Int = getColumnIndexOrThrow(_stmt, "wikipediaId")
        val _columnIndexOfBallotpediaId: Int = getColumnIndexOrThrow(_stmt, "ballotpediaId")
        val _columnIndexOfHouseHistoryId: Int = getColumnIndexOrThrow(_stmt, "houseHistoryId")
        val _columnIndexOfSenateHistoryId: Int = getColumnIndexOrThrow(_stmt, "senateHistoryId")
        val _columnIndexOfTermStart: Int = getColumnIndexOrThrow(_stmt, "termStart")
        val _columnIndexOfTermEnd: Int = getColumnIndexOrThrow(_stmt, "termEnd")
        val _columnIndexOfSenatorClass: Int = getColumnIndexOrThrow(_stmt, "senatorClass")
        val _columnIndexOfSenatorRank: Int = getColumnIndexOrThrow(_stmt, "senatorRank")
        val _columnIndexOfTwitter: Int = getColumnIndexOrThrow(_stmt, "twitter")
        val _columnIndexOfFacebook: Int = getColumnIndexOrThrow(_stmt, "facebook")
        val _columnIndexOfYoutube: Int = getColumnIndexOrThrow(_stmt, "youtube")
        val _columnIndexOfInstagram: Int = getColumnIndexOrThrow(_stmt, "instagram")
        val _columnIndexOfLastUpdated: Int = getColumnIndexOrThrow(_stmt, "lastUpdated")
        val _columnIndexOfIsActive: Int = getColumnIndexOrThrow(_stmt, "isActive")
        val _result: MutableList<CongressMember> = mutableListOf()
        while (_stmt.step()) {
          val _item: CongressMember
          val _tmpId: String
          _tmpId = _stmt.getText(_columnIndexOfId)
          val _tmpFirstName: String
          _tmpFirstName = _stmt.getText(_columnIndexOfFirstName)
          val _tmpLastName: String
          _tmpLastName = _stmt.getText(_columnIndexOfLastName)
          val _tmpFullName: String
          _tmpFullName = _stmt.getText(_columnIndexOfFullName)
          val _tmpTitle: String
          _tmpTitle = _stmt.getText(_columnIndexOfTitle)
          val _tmpParty: String
          _tmpParty = _stmt.getText(_columnIndexOfParty)
          val _tmpChamber: String
          _tmpChamber = _stmt.getText(_columnIndexOfChamber)
          val _tmpState: String
          _tmpState = _stmt.getText(_columnIndexOfState)
          val _tmpDistrict: String?
          if (_stmt.isNull(_columnIndexOfDistrict)) {
            _tmpDistrict = null
          } else {
            _tmpDistrict = _stmt.getText(_columnIndexOfDistrict)
          }
          val _tmpStateCode: String
          _tmpStateCode = _stmt.getText(_columnIndexOfStateCode)
          val _tmpPhoneNumber: String
          _tmpPhoneNumber = _stmt.getText(_columnIndexOfPhoneNumber)
          val _tmpEmail: String
          _tmpEmail = _stmt.getText(_columnIndexOfEmail)
          val _tmpWebsite: String?
          if (_stmt.isNull(_columnIndexOfWebsite)) {
            _tmpWebsite = null
          } else {
            _tmpWebsite = _stmt.getText(_columnIndexOfWebsite)
          }
          val _tmpOfficeAddress: String?
          if (_stmt.isNull(_columnIndexOfOfficeAddress)) {
            _tmpOfficeAddress = null
          } else {
            _tmpOfficeAddress = _stmt.getText(_columnIndexOfOfficeAddress)
          }
          val _tmpOfficeCity: String?
          if (_stmt.isNull(_columnIndexOfOfficeCity)) {
            _tmpOfficeCity = null
          } else {
            _tmpOfficeCity = _stmt.getText(_columnIndexOfOfficeCity)
          }
          val _tmpOfficeState: String?
          if (_stmt.isNull(_columnIndexOfOfficeState)) {
            _tmpOfficeState = null
          } else {
            _tmpOfficeState = _stmt.getText(_columnIndexOfOfficeState)
          }
          val _tmpOfficeZip: String?
          if (_stmt.isNull(_columnIndexOfOfficeZip)) {
            _tmpOfficeZip = null
          } else {
            _tmpOfficeZip = _stmt.getText(_columnIndexOfOfficeZip)
          }
          val _tmpOfficeBuilding: String?
          if (_stmt.isNull(_columnIndexOfOfficeBuilding)) {
            _tmpOfficeBuilding = null
          } else {
            _tmpOfficeBuilding = _stmt.getText(_columnIndexOfOfficeBuilding)
          }
          val _tmpOfficeRoom: String?
          if (_stmt.isNull(_columnIndexOfOfficeRoom)) {
            _tmpOfficeRoom = null
          } else {
            _tmpOfficeRoom = _stmt.getText(_columnIndexOfOfficeRoom)
          }
          val _tmpBioguideId: String?
          if (_stmt.isNull(_columnIndexOfBioguideId)) {
            _tmpBioguideId = null
          } else {
            _tmpBioguideId = _stmt.getText(_columnIndexOfBioguideId)
          }
          val _tmpGovtrackId: String?
          if (_stmt.isNull(_columnIndexOfGovtrackId)) {
            _tmpGovtrackId = null
          } else {
            _tmpGovtrackId = _stmt.getText(_columnIndexOfGovtrackId)
          }
          val _tmpOpensecretId: String?
          if (_stmt.isNull(_columnIndexOfOpensecretId)) {
            _tmpOpensecretId = null
          } else {
            _tmpOpensecretId = _stmt.getText(_columnIndexOfOpensecretId)
          }
          val _tmpVotesmartId: String?
          if (_stmt.isNull(_columnIndexOfVotesmartId)) {
            _tmpVotesmartId = null
          } else {
            _tmpVotesmartId = _stmt.getText(_columnIndexOfVotesmartId)
          }
          val _tmpFecId: String?
          if (_stmt.isNull(_columnIndexOfFecId)) {
            _tmpFecId = null
          } else {
            _tmpFecId = _stmt.getText(_columnIndexOfFecId)
          }
          val _tmpCspanId: String?
          if (_stmt.isNull(_columnIndexOfCspanId)) {
            _tmpCspanId = null
          } else {
            _tmpCspanId = _stmt.getText(_columnIndexOfCspanId)
          }
          val _tmpWikipediaId: String?
          if (_stmt.isNull(_columnIndexOfWikipediaId)) {
            _tmpWikipediaId = null
          } else {
            _tmpWikipediaId = _stmt.getText(_columnIndexOfWikipediaId)
          }
          val _tmpBallotpediaId: String?
          if (_stmt.isNull(_columnIndexOfBallotpediaId)) {
            _tmpBallotpediaId = null
          } else {
            _tmpBallotpediaId = _stmt.getText(_columnIndexOfBallotpediaId)
          }
          val _tmpHouseHistoryId: String?
          if (_stmt.isNull(_columnIndexOfHouseHistoryId)) {
            _tmpHouseHistoryId = null
          } else {
            _tmpHouseHistoryId = _stmt.getText(_columnIndexOfHouseHistoryId)
          }
          val _tmpSenateHistoryId: String?
          if (_stmt.isNull(_columnIndexOfSenateHistoryId)) {
            _tmpSenateHistoryId = null
          } else {
            _tmpSenateHistoryId = _stmt.getText(_columnIndexOfSenateHistoryId)
          }
          val _tmpTermStart: String?
          if (_stmt.isNull(_columnIndexOfTermStart)) {
            _tmpTermStart = null
          } else {
            _tmpTermStart = _stmt.getText(_columnIndexOfTermStart)
          }
          val _tmpTermEnd: String?
          if (_stmt.isNull(_columnIndexOfTermEnd)) {
            _tmpTermEnd = null
          } else {
            _tmpTermEnd = _stmt.getText(_columnIndexOfTermEnd)
          }
          val _tmpSenatorClass: String?
          if (_stmt.isNull(_columnIndexOfSenatorClass)) {
            _tmpSenatorClass = null
          } else {
            _tmpSenatorClass = _stmt.getText(_columnIndexOfSenatorClass)
          }
          val _tmpSenatorRank: String?
          if (_stmt.isNull(_columnIndexOfSenatorRank)) {
            _tmpSenatorRank = null
          } else {
            _tmpSenatorRank = _stmt.getText(_columnIndexOfSenatorRank)
          }
          val _tmpTwitter: String?
          if (_stmt.isNull(_columnIndexOfTwitter)) {
            _tmpTwitter = null
          } else {
            _tmpTwitter = _stmt.getText(_columnIndexOfTwitter)
          }
          val _tmpFacebook: String?
          if (_stmt.isNull(_columnIndexOfFacebook)) {
            _tmpFacebook = null
          } else {
            _tmpFacebook = _stmt.getText(_columnIndexOfFacebook)
          }
          val _tmpYoutube: String?
          if (_stmt.isNull(_columnIndexOfYoutube)) {
            _tmpYoutube = null
          } else {
            _tmpYoutube = _stmt.getText(_columnIndexOfYoutube)
          }
          val _tmpInstagram: String?
          if (_stmt.isNull(_columnIndexOfInstagram)) {
            _tmpInstagram = null
          } else {
            _tmpInstagram = _stmt.getText(_columnIndexOfInstagram)
          }
          val _tmpLastUpdated: Long
          _tmpLastUpdated = _stmt.getLong(_columnIndexOfLastUpdated)
          val _tmpIsActive: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfIsActive).toInt()
          _tmpIsActive = _tmp != 0
          _item = CongressMember(_tmpId,_tmpFirstName,_tmpLastName,_tmpFullName,_tmpTitle,_tmpParty,_tmpChamber,_tmpState,_tmpDistrict,_tmpStateCode,_tmpPhoneNumber,_tmpEmail,_tmpWebsite,_tmpOfficeAddress,_tmpOfficeCity,_tmpOfficeState,_tmpOfficeZip,_tmpOfficeBuilding,_tmpOfficeRoom,_tmpBioguideId,_tmpGovtrackId,_tmpOpensecretId,_tmpVotesmartId,_tmpFecId,_tmpCspanId,_tmpWikipediaId,_tmpBallotpediaId,_tmpHouseHistoryId,_tmpSenateHistoryId,_tmpTermStart,_tmpTermEnd,_tmpSenatorClass,_tmpSenatorRank,_tmpTwitter,_tmpFacebook,_tmpYoutube,_tmpInstagram,_tmpLastUpdated,_tmpIsActive)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getMemberCount(): Int {
    val _sql: String = "SELECT COUNT(*) FROM congress_members WHERE isActive = 1"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _result: Int
        if (_stmt.step()) {
          val _tmp: Int
          _tmp = _stmt.getLong(0).toInt()
          _result = _tmp
        } else {
          _result = 0
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getMemberCountByChamber(chamber: String): Int {
    val _sql: String = "SELECT COUNT(*) FROM congress_members WHERE isActive = 1 AND chamber = ?"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, chamber)
        val _result: Int
        if (_stmt.step()) {
          val _tmp: Int
          _tmp = _stmt.getLong(0).toInt()
          _result = _tmp
        } else {
          _result = 0
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getMemberCountByParty(party: String): Int {
    val _sql: String = "SELECT COUNT(*) FROM congress_members WHERE isActive = 1 AND party = ?"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, party)
        val _result: Int
        if (_stmt.step()) {
          val _tmp: Int
          _tmp = _stmt.getLong(0).toInt()
          _result = _tmp
        } else {
          _result = 0
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getAllStates(): List<String> {
    val _sql: String = "SELECT DISTINCT state FROM congress_members WHERE isActive = 1 ORDER BY state"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _result: MutableList<String> = mutableListOf()
        while (_stmt.step()) {
          val _item: String
          _item = _stmt.getText(0)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getAllParties(): List<String> {
    val _sql: String = "SELECT DISTINCT party FROM congress_members WHERE isActive = 1 ORDER BY party"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _result: MutableList<String> = mutableListOf()
        while (_stmt.step()) {
          val _item: String
          _item = _stmt.getText(0)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getTotalCount(): Int {
    val _sql: String = "SELECT COUNT(*) FROM congress_members"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _result: Int
        if (_stmt.step()) {
          val _tmp: Int
          _tmp = _stmt.getLong(0).toInt()
          _result = _tmp
        } else {
          _result = 0
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getLastUpdateTime(): Long? {
    val _sql: String = "SELECT MAX(lastUpdated) FROM congress_members"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _result: Long?
        if (_stmt.step()) {
          val _tmp: Long?
          if (_stmt.isNull(0)) {
            _tmp = null
          } else {
            _tmp = _stmt.getLong(0)
          }
          _result = _tmp
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun deleteAllMembers() {
    val _sql: String = "DELETE FROM congress_members"
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        _stmt.step()
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun deactivateMember(id: String) {
    val _sql: String = "UPDATE congress_members SET isActive = 0 WHERE id = ?"
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, id)
        _stmt.step()
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
