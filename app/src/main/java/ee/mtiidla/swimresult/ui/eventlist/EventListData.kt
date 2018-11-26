package ee.mtiidla.swimresult.ui.eventlist

import ee.mtiidla.swimresult.domain.model.Event
import ee.mtiidla.swimresult.domain.model.Session

sealed class EventListData(val id: Long) {

    data class EventItem(val event: Event) : EventListData(event.id)

    data class SessionItem(val session: Session) : EventListData(session.number.toLong())
}