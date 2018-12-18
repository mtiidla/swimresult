package ee.mtiidla.swimresult.domain.repo

import ee.mtiidla.swimresult.domain.service.EventService
import javax.inject.Inject

class EventRepository @Inject constructor(private val service: EventService) {

    suspend fun events(meetId: Long) = service.events(meetId)

    suspend fun sessions(meetId: Long) = service.sessions(meetId)

    suspend fun entries(meetId: Long, eventId: Long) = service.entries(meetId, eventId)

    suspend fun heats(meetId: Long, eventId: Long) = service.heats(meetId, eventId)

    suspend fun results(meetId: Long, eventId: Long) = service.results(meetId, eventId)
}