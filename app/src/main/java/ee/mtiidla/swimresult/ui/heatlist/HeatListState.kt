package ee.mtiidla.swimresult.ui.heatlist

import ee.mtiidla.swimresult.ui.heat.HeatState

sealed class HeatListState {

    object Loading : HeatListState()

    data class Data(val heats: List<HeatState>) : HeatListState()

}
