package ee.mtiidla.swimresult.ui.heat

import android.view.ViewGroup
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.ui.heat.HeatLaneListData.LaneItem
import ee.mtiidla.swimresult.util.ViewAdapterDelegate
import ee.mtiidla.swimresult.util.inflateView

class HeatLaneAdapterDelegate : ViewAdapterDelegate<LaneItem, HeatLaneListData, HeatLaneView>() {

    override fun createView(parent: ViewGroup): HeatLaneView =
        inflateView(parent, R.layout.list_item_heat_lane)

    override fun bindItem(item: LaneItem, view: HeatLaneView, payloads: List<Any>) {
        view.bindHeatLane(item.lane)
    }

    override fun isForViewType(
        item: HeatLaneListData,
        items: MutableList<HeatLaneListData>,
        position: Int
    ): Boolean = item is LaneItem
}