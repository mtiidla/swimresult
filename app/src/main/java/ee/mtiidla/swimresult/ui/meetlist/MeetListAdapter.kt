package ee.mtiidla.swimresult.ui.meetlist

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class MeetListAdapter : AsyncListDifferDelegationAdapter<MeetListData>(object :
    DiffUtil.ItemCallback<MeetListData>() {

    override fun areItemsTheSame(oldItem: MeetListData, newItem: MeetListData): Boolean =
        newItem::class == oldItem::class

    override fun areContentsTheSame(oldItem: MeetListData, newItem: MeetListData): Boolean =
        oldItem == newItem
}) {

    init {
        delegatesManager.addDelegate(MeetGroupAdapterDelegate())
        delegatesManager.addDelegate(MeetAdapterDelegate())
    }
}