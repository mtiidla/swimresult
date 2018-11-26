package ee.mtiidla.swimresult.ui.eventlist

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import ee.mtiidla.swimresult.domain.model.Event
import ee.mtiidla.swimresult.util.IdEqualsDiffCallback

class EventListAdapter(listener: (Event) -> Unit) :
    AsyncListDifferDelegationAdapter<EventListData>(
        IdEqualsDiffCallback<EventListData>(EventListData::id)
    ) {

    init {
        delegatesManager.addDelegate(EventAdapterDelegate(listener))
        delegatesManager.addDelegate(SessionAdapterDelegate())
    }

    override fun getItemId(position: Int): Long {
        return items[position].id
    }
}