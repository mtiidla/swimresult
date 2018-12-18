package ee.mtiidla.swimresult.domain.service

import ee.mtiidla.swimresult.domain.model.Athlete
import ee.mtiidla.swimresult.domain.model.AthleteDetails
import ee.mtiidla.swimresult.domain.model.Club
import ee.mtiidla.swimresult.domain.model.ClubDetails

interface CompetitorService {

    suspend fun athletes(meetId: Long): List<Athlete>

    suspend fun clubs(meetId: Long): List<Club>

    suspend fun athlete(meetId: Long, athleteId: Long): AthleteDetails

    suspend fun club(meetId: Long, clubId: Long): ClubDetails
}