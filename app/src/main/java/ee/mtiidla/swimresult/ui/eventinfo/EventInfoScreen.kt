package ee.mtiidla.swimresult.ui.eventinfo

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.ui.Screen
import ee.mtiidla.swimresult.ui.entrylist.EntryListState
import ee.mtiidla.swimresult.ui.heat.HeatState
import ee.mtiidla.swimresult.ui.resultlist.ResultListState
import ee.mtiidla.swimresult.util.gone
import ee.mtiidla.swimresult.util.inflateLayout
import ee.mtiidla.swimresult.util.notNull
import ee.mtiidla.swimresult.util.setStableIds
import ee.mtiidla.swimresult.util.visible
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.screen_event_info.*

class EventInfoScreen(context: Context) : Screen, LayoutContainer {

    override val containerView: ViewGroup = inflateLayout(context, R.layout.screen_event_info)

    override fun getRootView(): ViewGroup = containerView

    private val adapter = EventInfoAdapter()

    init {
        adapter.setStableIds()
        eventInfoListView.adapter = adapter
        eventInfoListView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        PagerSnapHelper().attachToRecyclerView(eventInfoListView)
    }

    fun render(state: EventInfoState) {

        when (state) {
            is EventInfoState.Loading -> {
                eventInfoListView.gone()
                progressBar.visible()
            }
            is EventInfoState.Data -> {
                eventInfoListView.visible()
                progressBar.gone()

                val adapterData = mutableListOf<EventInfoData>()
                state.eventInfo.entries.notNull {
                    adapterData += EventInfoData.EntryListItem(EntryListState.Data(it))
                }
                state.eventInfo.results.notNull {
                    adapterData += EventInfoData.ResultListItem(ResultListState.Data(it))
                }
                state.eventInfo.heats.notNull {
                    adapterData += it.map { heat -> EventInfoData.HeatItem(HeatState.Data(heat)) }
                }
                adapter.items = adapterData
            }
        }
    }
}