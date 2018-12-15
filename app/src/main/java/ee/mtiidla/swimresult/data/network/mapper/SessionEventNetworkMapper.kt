package ee.mtiidla.swimresult.data.network.mapper

import ee.mtiidla.swimresult.data.network.model.SessionEventNetworkModel
import ee.mtiidla.swimresult.domain.model.Event
import ee.mtiidla.swimresult.domain.model.SessionEvent
import javax.inject.Inject

class SessionEventNetworkMapper @Inject constructor() :
    NetworkMapper<SessionEventNetworkModel, SessionEvent> {

    override fun map(item: SessionEventNetworkModel): SessionEvent = with(item) {
        SessionEvent(mapEventStatus(status), id.toLong())
    }

    private fun mapEventStatus(status: Int): Event.Status = when (status) {
        0 -> Event.Status.INVITATION
        1 -> Event.Status.ENTRIES
        2 -> Event.Status.SEEDED
        3 -> Event.Status.ONGOING
        5 -> Event.Status.FINISHED
        else -> Event.Status.UNKNOWN
    }
}