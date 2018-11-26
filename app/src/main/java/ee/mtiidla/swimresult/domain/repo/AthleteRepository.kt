package ee.mtiidla.swimresult.domain.repo

import ee.mtiidla.swimresult.domain.network.service.AthleteService
import javax.inject.Inject

class AthleteRepository @Inject constructor(private val athleteService: AthleteService) {

    fun athletes(meetId: Long) = athleteService.athletes(meetId)
}