package ee.mtiidla.swimresult.domain.repo

import ee.mtiidla.swimresult.domain.service.MeetService
import javax.inject.Inject

class MeetRepository @Inject constructor(private val service: MeetService) {

    fun meetGroups() = service.meets()

    fun meet(meetId: Long) = service.meet(meetId)

    fun ageGroups(meetId: Long) = service.ageGroups(meetId)
}