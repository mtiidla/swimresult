package ee.mtiidla.swimresult.ui.eventinfo

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import ee.mtiidla.swimresult.ui.resultlist.ResultListScreen
import ee.mtiidla.swimresult.util.IdEqualsDiffCallback

class EventInfoAdapter(listener: EventInfoListener) :
    AsyncListDifferDelegationAdapter<EventInfoData>(IdEqualsDiffCallback<EventInfoData>(EventInfoData::id)) {

    init {
        delegatesManager.addDelegate(HeatScreenAdapterDelegate())
        delegatesManager.addDelegate(EntryListScreenAdapterDelegate())
        delegatesManager.addDelegate(ResultListScreenAdapterDelegate(listener))
    }

    override fun getItemId(position: Int): Long {
        return items[position].id
    }

    interface EventInfoListener : ResultListScreen.Listener {

    }

}