package ee.mtiidla.swimresult.ui.club.adapter

import android.view.ViewGroup
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.ui.club.ClubAdapterData
import ee.mtiidla.swimresult.ui.club.ClubAdapterData.EntryItem
import ee.mtiidla.swimresult.ui.resultsummary.EntrySummaryView
import ee.mtiidla.swimresult.util.ViewAdapterDelegate
import ee.mtiidla.swimresult.util.inflateView

class ClubEntrySummaryAdapterDelegate :
    ViewAdapterDelegate<EntryItem, ClubAdapterData, EntrySummaryView>() {

    override fun createView(parent: ViewGroup): EntrySummaryView = inflateView(parent, R.layout.list_item_entry_summary)

    override fun bindItem(
        item: EntryItem,
        view: EntrySummaryView,
        payloads: List<Any>
    ) {
       view.bindEntrySummary(item.entry)
    }

    override fun isForViewType(
        item: ClubAdapterData,
        items: MutableList<ClubAdapterData>,
        position: Int
    ): Boolean = item is EntryItem
}