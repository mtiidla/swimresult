package ee.mtiidla.swimresult.domain.repo

import ee.mtiidla.swimresult.domain.network.service.EventService
import javax.inject.Inject

class EventRepository @Inject constructor(private val service: EventService) {

    fun events(meetId: Long) = service.events(meetId)

}