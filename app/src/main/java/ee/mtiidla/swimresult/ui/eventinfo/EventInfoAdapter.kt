package ee.mtiidla.swimresult.ui.eventinfo

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import ee.mtiidla.swimresult.util.IdEqualsDiffCallback

class EventInfoAdapter :
    AsyncListDifferDelegationAdapter<EventInfoData>(IdEqualsDiffCallback<EventInfoData>(EventInfoData::id)) {

    init {
        delegatesManager.addDelegate(HeatScreenAdapterDelegate())
        delegatesManager.addDelegate(EntryListScreenAdapterDelegate())
    }

    override fun getItemId(position: Int): Long {
        return items[position].id
    }
}