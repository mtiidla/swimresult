package ee.mtiidla.swimresult.ui.eventlist

import ee.mtiidla.swimresult.domain.model.Event

sealed class EventListData(val id: Long) {

    data class EventItem(val event: Event) : EventListData(event.id)
}