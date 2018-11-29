package ee.mtiidla.swimresult.ui.eventinfo

import ee.mtiidla.swimresult.domain.model.EventInfo

sealed class EventInfoState {

    object Loading : EventInfoState()

    data class Data(val eventInfo: EventInfo) : EventInfoState()

}
