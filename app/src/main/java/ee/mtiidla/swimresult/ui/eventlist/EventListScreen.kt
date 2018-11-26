package ee.mtiidla.swimresult.ui.eventlist

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.ui.Screen
import ee.mtiidla.swimresult.util.gone
import ee.mtiidla.swimresult.util.inflateLayout
import ee.mtiidla.swimresult.util.visible
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.screen_event_list.*
import timber.log.Timber

class EventListScreen(context: Context) : Screen, LayoutContainer {

    override fun getRootView(): ViewGroup = containerView

    override val containerView: ViewGroup = inflateLayout(context, R.layout.screen_event_list)

    private val adapter : EventListAdapter

    init {
        adapter = EventListAdapter { event -> Timber.d(event.toString()) }
        adapter.setHasStableIds(true)
        eventListView.adapter = adapter
        eventListView.layoutManager = LinearLayoutManager(context)
    }

    fun render(state: EventListState) {
        when (state) {
            is EventListState.Loading -> {
                progressBar.visible()
                eventListView.gone()
            }
            is EventListState.Data -> {
                progressBar.gone()
                eventListView.visible()

                val adapterData = mutableListOf<EventListData>()
                state.eventsBySession.forEach {
                    adapterData += EventListData.SessionItem(it.key)
                    adapterData += it.value.map { event -> EventListData.EventItem(event) }
                }

                adapter.items = adapterData
            }
            is EventListState.Error -> TODO()
        }
    }
}