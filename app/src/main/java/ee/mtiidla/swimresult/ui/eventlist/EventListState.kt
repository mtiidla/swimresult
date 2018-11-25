package ee.mtiidla.swimresult.ui.eventlist

import ee.mtiidla.swimresult.domain.model.Event

sealed class EventListState {

    object Loading : EventListState()

    data class Data(val events: List<Event>) : EventListState()

    data class Error(val error: Throwable) : EventListState()
}
