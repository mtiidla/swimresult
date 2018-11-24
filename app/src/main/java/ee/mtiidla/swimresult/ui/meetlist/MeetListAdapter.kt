package ee.mtiidla.swimresult.ui.meetlist

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import ee.mtiidla.swimresult.domain.model.Meet

class MeetListAdapter(listener: (Meet) -> Unit) :
    AsyncListDifferDelegationAdapter<MeetListData>(object :
        DiffUtil.ItemCallback<MeetListData>() {

        override fun areItemsTheSame(oldItem: MeetListData, newItem: MeetListData): Boolean =
            newItem::class == oldItem::class

        override fun areContentsTheSame(oldItem: MeetListData, newItem: MeetListData): Boolean =
            oldItem == newItem
    }) {

    init {
        delegatesManager.addDelegate(MeetGroupAdapterDelegate())
        delegatesManager.addDelegate(MeetAdapterDelegate(listener))
    }
}