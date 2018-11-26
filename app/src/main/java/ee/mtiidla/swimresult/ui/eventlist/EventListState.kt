package ee.mtiidla.swimresult.ui.eventlist

import ee.mtiidla.swimresult.domain.model.Event
import ee.mtiidla.swimresult.domain.model.Session

sealed class EventListState {

    object Loading : EventListState()

    data class Data(val eventsBySession: Map<Session, List<Event>>) : EventListState()

    data class Error(val error: Throwable) : EventListState()
}
