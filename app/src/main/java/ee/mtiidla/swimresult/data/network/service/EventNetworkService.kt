package ee.mtiidla.swimresult.data.network.service

import ee.mtiidla.swimresult.data.network.RestApi
import ee.mtiidla.swimresult.data.network.mapper.AgeGroupResultNetworkMapper
import ee.mtiidla.swimresult.data.network.mapper.EntryNetworkMapper
import ee.mtiidla.swimresult.data.network.mapper.EventNetworkMapper
import ee.mtiidla.swimresult.data.network.mapper.HeatNetworkMapper
import ee.mtiidla.swimresult.data.network.mapper.SessionNetworkMapper
import ee.mtiidla.swimresult.domain.model.AgeGroupResults
import ee.mtiidla.swimresult.domain.model.Entry
import ee.mtiidla.swimresult.domain.model.Event
import ee.mtiidla.swimresult.domain.model.Heat
import ee.mtiidla.swimresult.domain.model.Session
import ee.mtiidla.swimresult.domain.service.EventService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import javax.inject.Inject

class EventNetworkService @Inject constructor(
    private val restApi: RestApi,
    private val eventMapper: EventNetworkMapper,
    private val sessionMapper: SessionNetworkMapper,
    private val entryMapper: EntryNetworkMapper,
    private val heatMapper: HeatNetworkMapper,
    private val resultMapper: AgeGroupResultNetworkMapper
) : EventService {

    override fun events(meetId: Long): Deferred<List<Event>> =
        CoroutineScope(Dispatchers.IO).async {

            val events = restApi.getEvents(meetId).await()

            return@async eventMapper.map(events.events)
        }

    override fun sessions(meetId: Long): Deferred<List<Session>> =
        CoroutineScope(Dispatchers.IO).async {

            val sessions = restApi.getEventsBySession(meetId).await()

            return@async sessionMapper.map(sessions.sessions)
        }

    override fun entries(meetId: Long, eventId: Long): Deferred<List<Entry>> =
        CoroutineScope(Dispatchers.IO).async {

            val entries = restApi.getEntries(meetId, eventId).await()

            return@async entryMapper.map(entries.entries)
        }

    override fun heats(meetId: Long, eventId: Long): Deferred<List<Heat>> =
        CoroutineScope(Dispatchers.IO).async {

            val heats = restApi.getHeats(meetId, eventId).await()

            return@async heatMapper.map(heats.heats)
        }

    override fun results(meetId: Long, eventId: Long): Deferred<List<AgeGroupResults>> =
        CoroutineScope(Dispatchers.IO).async {

            val results = restApi.getResults(meetId, eventId).await()

            return@async resultMapper.map(results.agegroups)
        }
}
