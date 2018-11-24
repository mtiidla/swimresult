package ee.mtiidla.swimresult.ui.meetlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.Meet
import ee.mtiidla.swimresult.ui.meetlist.MeetAdapterDelegate.MeetItemViewHolder
import ee.mtiidla.swimresult.ui.meetlist.MeetListData.MeetItem
import ee.mtiidla.swimresult.util.notNull
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_meet.*

class MeetAdapterDelegate(private val listener: (Meet) -> Unit) :
    AbsListItemAdapterDelegate<MeetItem, MeetListData, MeetItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup): MeetItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_meet, parent, false)
        return MeetItemViewHolder(view, listener)
    }

    override fun isForViewType(
        item: MeetListData,
        items: MutableList<MeetListData>,
        position: Int
    ) = item is MeetItem

    override fun onBindViewHolder(
        item: MeetItem,
        holder: MeetItemViewHolder,
        payloads: MutableList<Any>
    ) {
        holder.render(item)
    }

    class MeetItemViewHolder(
        override val containerView: View,
        private val listener: (Meet) -> Unit
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        private var item: MeetItem? = null

        init {
            containerView.setOnClickListener {
                item.notNull { meetItem ->
                    listener.invoke(meetItem.meet)
                }
            }
        }

        fun render(item: MeetItem) {
            this.item = item
            meetTitleView.text = item.meet.name
        }
    }
}