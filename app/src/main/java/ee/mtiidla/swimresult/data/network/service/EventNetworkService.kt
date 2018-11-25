package ee.mtiidla.swimresult.data.network.service

import ee.mtiidla.swimresult.data.network.RestApi
import ee.mtiidla.swimresult.data.network.mapper.EventNetworkMapper
import ee.mtiidla.swimresult.domain.model.Event
import ee.mtiidla.swimresult.domain.network.service.EventService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import javax.inject.Inject

class EventNetworkService @Inject constructor(
    private val restApi: RestApi,
    private val eventMapper: EventNetworkMapper
) : EventService {

    override fun events(meetId: Long): Deferred<List<Event>> =
        CoroutineScope(Dispatchers.IO).async {

            val events = restApi.getEvents(meetId).await()

            return@async eventMapper.map(events.events)
        }
}