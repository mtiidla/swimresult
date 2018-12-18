package ee.mtiidla.swimresult.domain.service

import ee.mtiidla.swimresult.domain.model.AgeGroupResults
import ee.mtiidla.swimresult.domain.model.Entry
import ee.mtiidla.swimresult.domain.model.Event
import ee.mtiidla.swimresult.domain.model.Heat
import ee.mtiidla.swimresult.domain.model.Session

interface EventService {

    suspend fun events(meetId: Long) : List<Event>

    suspend fun sessions(meetId: Long): List<Session>

    suspend fun entries(meetId: Long, eventId: Long): List<Entry>

    suspend fun heats(meetId: Long, eventId: Long): List<Heat>

    suspend fun results(meetId: Long, eventId: Long): List<AgeGroupResults>
}