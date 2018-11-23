package ee.mtiidla.swimresult.data.repo

import ee.mtiidla.swimresult.data.network.service.MeetService
import javax.inject.Inject

class MeetRepository @Inject constructor(private val service: MeetService) {

    fun meetGroups() = service.meets()

}