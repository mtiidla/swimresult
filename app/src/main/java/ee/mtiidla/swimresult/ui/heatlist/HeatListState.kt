package ee.mtiidla.swimresult.ui.heatlist

import ee.mtiidla.swimresult.domain.model.EventInfo

sealed class HeatListState {

    object Loading : HeatListState()

    data class Data(val eventInfo: EventInfo) : HeatListState()

}
