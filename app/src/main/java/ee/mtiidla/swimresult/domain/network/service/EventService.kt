package ee.mtiidla.swimresult.domain.network.service

import ee.mtiidla.swimresult.domain.model.Event
import kotlinx.coroutines.Deferred

interface EventService {

    fun events(meetId: Long) : Deferred<List<Event>>

}