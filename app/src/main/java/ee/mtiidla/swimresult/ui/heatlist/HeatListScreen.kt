package ee.mtiidla.swimresult.ui.heatlist

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.ui.Screen
import ee.mtiidla.swimresult.ui.entrylist.EntryListState
import ee.mtiidla.swimresult.ui.heat.HeatState
import ee.mtiidla.swimresult.util.gone
import ee.mtiidla.swimresult.util.inflateLayout
import ee.mtiidla.swimresult.util.notNull
import ee.mtiidla.swimresult.util.setStableIds
import ee.mtiidla.swimresult.util.visible
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.screen_heat_list.*

class HeatListScreen(context: Context) : Screen,LayoutContainer {

    override val containerView: ViewGroup = inflateLayout(context, R.layout.screen_heat_list)

    override fun getRootView(): ViewGroup = containerView

    private val adapter = HeatListAdapter()

    init {
        adapter.setStableIds()
        heatListView.adapter = adapter
        heatListView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        PagerSnapHelper().attachToRecyclerView(heatListView)
    }

    fun render(state: HeatListState) {

        when (state) {
            is HeatListState.Loading -> {
                heatListView.gone()
                progressBar.visible()
            }
            is HeatListState.Data -> {
                heatListView.visible()
                progressBar.gone()

                val adapterData = mutableListOf<HeatListData>()
                state.eventInfo.entries.notNull {
                    adapterData += HeatListData.EntryListItem(EntryListState.Data(it))
                }
                state.eventInfo.heats.notNull {
                    adapterData += it.map { heat -> HeatListData.HeatItem(HeatState.Data(heat)) }
                }
                adapter.items = adapterData
            }
        }

    }

}