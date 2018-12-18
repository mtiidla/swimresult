package ee.mtiidla.swimresult.domain.repo

import ee.mtiidla.swimresult.domain.service.CompetitorService
import javax.inject.Inject

class CompetitorRepository @Inject constructor(private val competitorService: CompetitorService) {

    suspend fun athletes(meetId: Long) = competitorService.athletes(meetId)

    suspend fun clubs(meetId: Long) = competitorService.clubs(meetId)

    suspend fun athlete(meetId: Long, athleteId: Long) = competitorService.athlete(meetId, athleteId)

    suspend fun club(meetId: Long, clubId: Long) = competitorService.club(meetId, clubId)
}