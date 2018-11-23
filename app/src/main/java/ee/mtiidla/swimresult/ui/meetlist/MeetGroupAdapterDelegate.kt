package ee.mtiidla.swimresult.ui.meetlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.ui.meetlist.MeetListData.MeetGroupItem
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_meet_group.*

class MeetGroupAdapterDelegate :
    AbsListItemAdapterDelegate<MeetGroupItem, MeetListData, MeetGroupAdapterDelegate.MeetGroupItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): MeetGroupItemViewHolder =
        MeetGroupItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_meet_group, parent, false)
        )

    override fun onBindViewHolder(
        item: MeetGroupItem,
        holder: MeetGroupItemViewHolder,
        payloads: MutableList<Any>
    ) {
        holder.render(item)
    }

    override fun isForViewType(
        item: MeetListData,
        items: MutableList<MeetListData>,
        position: Int
    ) = item is MeetGroupItem

    class MeetGroupItemViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun render(item: MeetGroupItem) {
            meetGroupTitleView.text = item.title
        }
    }
}