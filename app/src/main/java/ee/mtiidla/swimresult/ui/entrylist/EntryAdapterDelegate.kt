package ee.mtiidla.swimresult.ui.entrylist

import android.view.ViewGroup
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.util.ViewAdapterDelegate
import ee.mtiidla.swimresult.util.inflateView

class EntryAdapterDelegate :
    ViewAdapterDelegate<EntryListData.EntryItem, EntryListData, EntryView>() {

    override fun createView(parent: ViewGroup): EntryView =
        inflateView(parent, R.layout.list_item_entry)

    override fun bindItem(item: EntryListData.EntryItem, view: EntryView, payloads: List<Any>) {
        view.bindEntry(item.entry)
    }

    override fun isForViewType(
        item: EntryListData,
        items: MutableList<EntryListData>,
        position: Int
    ): Boolean = item is EntryListData.EntryItem
}