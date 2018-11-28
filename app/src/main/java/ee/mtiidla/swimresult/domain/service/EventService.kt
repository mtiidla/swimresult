package ee.mtiidla.swimresult.domain.service

import ee.mtiidla.swimresult.domain.model.Entry
import ee.mtiidla.swimresult.domain.model.Event
import ee.mtiidla.swimresult.domain.model.Heat
import ee.mtiidla.swimresult.domain.model.Session
import kotlinx.coroutines.Deferred

interface EventService {

    fun events(meetId: Long) : Deferred<List<Event>>

    fun sessions(meetId: Long): Deferred<List<Session>>

    fun entries(meetId: Long, eventId: Long): Deferred<List<Entry>>

    fun heats(meetId: Long, eventId: Long): Deferred<List<Heat>>
}