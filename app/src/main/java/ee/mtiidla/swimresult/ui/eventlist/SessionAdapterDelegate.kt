package ee.mtiidla.swimresult.ui.eventlist

import android.view.ViewGroup
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.util.ViewAdapterDelegate
import ee.mtiidla.swimresult.util.inflateView

class SessionAdapterDelegate :
    ViewAdapterDelegate<EventListData.SessionItem, EventListData, SessionView>() {

    override fun createView(parent: ViewGroup): SessionView =
        inflateView(parent, R.layout.list_item_session)

    override fun bindItem(item: EventListData.SessionItem, view: SessionView, payloads: List<Any>) {
        view.bindSession(item.session)
    }

    override fun isForViewType(
        item: EventListData,
        items: MutableList<EventListData>,
        position: Int
    ) = item is EventListData.SessionItem
}