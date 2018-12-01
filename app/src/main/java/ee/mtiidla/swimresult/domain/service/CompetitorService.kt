package ee.mtiidla.swimresult.domain.service

import ee.mtiidla.swimresult.domain.model.Athlete
import ee.mtiidla.swimresult.domain.model.AthleteDetails
import ee.mtiidla.swimresult.domain.model.Club
import ee.mtiidla.swimresult.domain.model.ClubDetails
import kotlinx.coroutines.Deferred

interface CompetitorService {

    fun athletes(meetId: Long): Deferred<List<Athlete>>

    fun clubs(meetId: Long): Deferred<List<Club>>

    fun athlete(meetId: Long, athleteId: Long): Deferred<AthleteDetails>

    fun club(meetId: Long, clubId: Long): Deferred<ClubDetails>
}