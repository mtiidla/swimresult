package ee.mtiidla.swimresult.data.network.mapper

import ee.mtiidla.swimresult.data.network.model.SessionEventNetworkModel
import ee.mtiidla.swimresult.domain.model.SessionEvent
import javax.inject.Inject

class SessionEventNetworkMapper @Inject constructor() :
    NetworkMapper<SessionEventNetworkModel, SessionEvent> {
    override fun map(item: SessionEventNetworkModel): SessionEvent = with(item) {
        SessionEvent(status, id.toLong())
    }
}