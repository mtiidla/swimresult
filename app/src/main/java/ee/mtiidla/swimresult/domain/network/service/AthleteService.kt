package ee.mtiidla.swimresult.domain.network.service

import ee.mtiidla.swimresult.domain.model.Athlete
import kotlinx.coroutines.Deferred

interface AthleteService {

    fun athletes(meetId: Long): Deferred<List<Athlete>>
}