package ee.mtiidla.swimresult.domain.repo

import ee.mtiidla.swimresult.domain.service.EventService
import javax.inject.Inject

class EventRepository @Inject constructor(private val service: EventService) {

    fun events(meetId: Long) = service.events(meetId)

    fun sessions(meetId: Long) = service.sessions(meetId)

    fun entries(meetId: Long, eventId: Long) = service.entries(meetId, eventId)

    fun heats(meetId: Long, eventId: Long) = service.heats(meetId, eventId)
}