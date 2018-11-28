package ee.mtiidla.swimresult.ui.heat

import ee.mtiidla.swimresult.domain.model.HeatLane

sealed class HeatLaneListData(val id: Long) {

    data class LaneItem(val lane : HeatLane) : HeatLaneListData(lane.hashCode().toLong()) // TODO: Marko 27.11.2018 create id

}