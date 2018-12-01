package ee.mtiidla.swimresult.domain.repo

import ee.mtiidla.swimresult.domain.service.CompetitorService
import javax.inject.Inject

class CompetitorRepository @Inject constructor(private val competitorService: CompetitorService) {

    fun athletes(meetId: Long) = competitorService.athletes(meetId)

    fun clubs(meetId: Long) = competitorService.clubs(meetId)

    fun athlete(meetId: Long, athleteId: Long) = competitorService.athlete(meetId, athleteId)

    fun club(meetId: Long, clubId: Long) = competitorService.club(meetId, clubId)
}