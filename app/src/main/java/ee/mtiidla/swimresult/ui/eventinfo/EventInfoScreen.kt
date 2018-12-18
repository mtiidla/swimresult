package ee.mtiidla.swimresult.ui.eventinfo

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.Event
import ee.mtiidla.swimresult.ui.Screen
import ee.mtiidla.swimresult.ui.entrylist.EntryListState
import ee.mtiidla.swimresult.ui.heat.HeatState
import ee.mtiidla.swimresult.ui.resultlist.ResultListState
import ee.mtiidla.swimresult.util.gone
import ee.mtiidla.swimresult.util.inflateLayout
import ee.mtiidla.swimresult.util.notNull
import ee.mtiidla.swimresult.util.setStableIds
import ee.mtiidla.swimresult.util.setupWithRecyclerView
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
        val linearLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        eventInfoListView.layoutManager = linearLayoutManager
        eventInfoListView.setScrollingTouchSlop(RecyclerView.TOUCH_SLOP_PAGING)
        PagerSnapHelper().attachToRecyclerView(eventInfoListView)
        eventInfoTabView.setupWithRecyclerView(eventInfoListView)
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

                val tabs = mutableListOf<String>()
                val adapterData = mutableListOf<EventInfoData>()
                state.eventInfo.entries.notNull {
                    tabs += "Entries"
                    adapterData += EventInfoData.EntryListItem(EntryListState.Data(it))
                }
                state.eventInfo.results.notNull {
                    tabs += "Results"
                    adapterData += EventInfoData.ResultListItem(ResultListState.Data(it))
                }
                state.eventInfo.heats.notNull {
                    it.forEach { heat ->
                        val label = if (state.eventInfo.event.round == Event.Round.FINAL) "Final" else "Heat"
                        tabs +=   "$label ${heat.code}"
                        adapterData += EventInfoData.HeatItem(HeatState.Data(heat))
                    }
                }
                adapter.items = adapterData
                renderTabs(tabs)
            }
        }
    }

    private fun renderTabs(tabs: List<String>) {

        eventInfoTabView.removeAllTabs()
        tabs.forEach {
            val tab = eventInfoTabView.newTab()
            tab.text = it
            eventInfoTabView.addTab(tab)
        }
    }
}