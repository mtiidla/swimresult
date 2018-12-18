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
import javax.inject.Inject

class EventNetworkService @Inject constructor(
    private val restApi: RestApi,
    private val eventMapper: EventNetworkMapper,
    private val sessionMapper: SessionNetworkMapper,
    private val entryMapper: EntryNetworkMapper,
    private val heatMapper: HeatNetworkMapper,
    private val resultMapper: AgeGroupResultNetworkMapper
) : EventService {

    override suspend fun events(meetId: Long): List<Event> {

        val events = restApi.getEvents(meetId).await()

        return eventMapper.map(events.events)
    }

    override suspend fun sessions(meetId: Long): List<Session> {

        val sessions = restApi.getEventsBySession(meetId).await()

        return sessionMapper.map(sessions.sessions)
    }

    override suspend fun entries(meetId: Long, eventId: Long): List<Entry> {

        val entries = restApi.getEntries(meetId, eventId).await()

        return entryMapper.map(entries.entries)
    }

    override suspend fun heats(meetId: Long, eventId: Long): List<Heat> {

        val heats = restApi.getHeats(meetId, eventId).await()

        return heatMapper.map(heats.heats)
    }

    override suspend fun results(meetId: Long, eventId: Long): List<AgeGroupResults> {

        val results = restApi.getResults(meetId, eventId).await()

        return resultMapper.map(results.agegroups)
    }
}
