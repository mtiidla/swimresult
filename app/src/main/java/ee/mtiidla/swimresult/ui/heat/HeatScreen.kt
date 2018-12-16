package ee.mtiidla.swimresult.ui.heat

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.HeatLane
import ee.mtiidla.swimresult.ui.Screen
import ee.mtiidla.swimresult.util.inflateLayout
import ee.mtiidla.swimresult.util.setStableIds
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.screen_heat.*

class HeatScreen(context: Context) : Screen, LayoutContainer {

    override val containerView: ViewGroup = inflateLayout(context, R.layout.screen_heat)

    override fun getRootView(): ViewGroup = containerView

    private val adapter = HeatAdapter()

    init {
        adapter.setStableIds()
        heatLaneListView.adapter = adapter
        heatLaneListView.layoutManager = LinearLayoutManager(context)
    }

    fun render(state: HeatState) {
        when (state) {
            is HeatState.Data -> {
                adapter.items = state.heat.entries.map { HeatLaneListData.LaneItem(HeatLane(it)) }
            }
        }
    }

}