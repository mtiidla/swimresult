package ee.mtiidla.swimresult.ui.eventlist

import android.view.ViewGroup
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.Event
import ee.mtiidla.swimresult.util.ViewAdapterDelegate
import ee.mtiidla.swimresult.util.inflateView

class EventAdapterDelegate(listener: (Event) -> Unit) :
    ViewAdapterDelegate<EventListData.EventItem, EventListData, EventView>({ listener.invoke(it.event) }) {

    override fun createView(parent: ViewGroup): EventView =
        inflateView(parent, R.layout.list_item_event)

    override fun bindItem(item: EventListData.EventItem, view: EventView, payloads: List<Any>) {
        view.bindEvent(item.event)
    }

    override fun isForViewType(
        item: EventListData,
        items: MutableList<EventListData>,
        position: Int
    ): Boolean = item is EventListData.EventItem
}