package ee.mtiidla.swimresult.ui.club.adapter

import android.view.ViewGroup
import android.widget.TextView
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.ui.club.ClubAdapterData
import ee.mtiidla.swimresult.ui.club.ClubAdapterData.EntryHeaderItem
import ee.mtiidla.swimresult.util.ViewAdapterDelegate
import ee.mtiidla.swimresult.util.inflateView

class EntryHeaderAdapterDelegate :
    ViewAdapterDelegate<EntryHeaderItem, ClubAdapterData, TextView>() {
    override fun createView(parent: ViewGroup): TextView =
        inflateView(parent, R.layout.list_item_entry_summary_header)

    override fun bindItem(item: EntryHeaderItem, view: TextView, payloads: List<Any>) {
        // do nothing, static layout
    }

    override fun isForViewType(
        item: ClubAdapterData,
        items: MutableList<ClubAdapterData>,
        position: Int
    ): Boolean = item is EntryHeaderItem
}