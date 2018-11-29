package ee.mtiidla.swimresult.ui.event

import ee.mtiidla.swimresult.domain.model.EventInfo

sealed class EventState {

    object Loading : EventState()

    data class Data(val eventInfo: EventInfo) : EventState()

    data class Error(val error: Throwable) : EventState()
}
