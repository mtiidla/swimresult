package ee.mtiidla.swimresult.ui.heatlist

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ee.mtiidla.swimresult.ui.entrylist.EntryListScreen
import ee.mtiidla.swimresult.util.ViewHolderAdapterDelegate

class EntryListAdapterDelegate :
    ViewHolderAdapterDelegate<HeatListData.EntryListItem, HeatListData, EntryListAdapterDelegate.EntryListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup) = EntryListViewHolder(EntryListScreen(parent.context))

    override fun onBindViewHolder(
        item: HeatListData.EntryListItem,
        holder: EntryListViewHolder,
        payloads: MutableList<Any>
    ) {
        holder.screen.render(item.entryListState)
    }

    override fun isForViewType(
        item: HeatListData,
        items: MutableList<HeatListData>,
        position: Int
    ): Boolean = item is HeatListData.EntryListItem

    class EntryListViewHolder(internal val screen: EntryListScreen) :
        RecyclerView.ViewHolder(screen.getRootView()) {
        init {
            val windowWidth = 1080 // TODO: Marko 27.11.2018 real window width
            itemView.layoutParams = RecyclerView.LayoutParams(windowWidth, RecyclerView.LayoutParams.MATCH_PARENT)
        }
    }
}