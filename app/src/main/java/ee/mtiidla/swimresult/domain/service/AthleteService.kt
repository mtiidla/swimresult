package ee.mtiidla.swimresult.domain.service

import ee.mtiidla.swimresult.domain.model.Athlete
import ee.mtiidla.swimresult.domain.model.Club
import kotlinx.coroutines.Deferred

interface AthleteService {

    fun athletes(meetId: Long): Deferred<List<Athlete>>

    fun clubs(meetId: Long): Deferred<List<Club>>
}