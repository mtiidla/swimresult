package ee.mtiidla.swimresult.ui.eventinfo

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ee.mtiidla.swimresult.ui.entrylist.EntryListScreen
import ee.mtiidla.swimresult.util.ViewHolderAdapterDelegate

class EntryListScreenAdapterDelegate :
    ViewHolderAdapterDelegate<EventInfoData.EntryListItem, EventInfoData, EntryListScreenAdapterDelegate.EntryListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup) = EntryListViewHolder(EntryListScreen(parent.context))

    override fun onBindViewHolder(
        item: EventInfoData.EntryListItem,
        holder: EntryListViewHolder,
        payloads: MutableList<Any>
    ) {
        holder.screen.render(item.entryListState)
    }

    override fun isForViewType(
        item: EventInfoData,
        items: MutableList<EventInfoData>,
        position: Int
    ): Boolean = item is EventInfoData.EntryListItem

    class EntryListViewHolder(internal val screen: EntryListScreen) :
        RecyclerView.ViewHolder(screen.getRootView()) {
        init {
            val windowWidth = 1080 // TODO: Marko 27.11.2018 real window width
            itemView.layoutParams = RecyclerView.LayoutParams(windowWidth, RecyclerView.LayoutParams.MATCH_PARENT)
        }
    }
}