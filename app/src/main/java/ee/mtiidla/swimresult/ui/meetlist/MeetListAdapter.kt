package ee.mtiidla.swimresult.ui.meetlist

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import ee.mtiidla.swimresult.domain.model.Meet
import ee.mtiidla.swimresult.util.IdEqualsDiffCallback

class MeetListAdapter(listener: (Meet) -> Unit) :
    AsyncListDifferDelegationAdapter<MeetListData>(
        IdEqualsDiffCallback<MeetListData>(MeetListData::id)
    ) {

    init {
        delegatesManager.addDelegate(MeetGroupAdapterDelegate())
        delegatesManager.addDelegate(MeetAdapterDelegate(listener))
    }

    override fun getItemId(position: Int): Long {
        return items[position].id
    }
}