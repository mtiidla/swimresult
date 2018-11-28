package ee.mtiidla.swimresult.ui.heatlist

import ee.mtiidla.swimresult.ui.heat.HeatState

sealed class HeatListData(val id : Long) {

    data class HeatItem(val heatState: HeatState) : HeatListData(heatState.hashCode().toLong()) // TODO: Marko 27.11.2018 id


}