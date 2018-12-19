package ee.mtiidla.swimresult.ui.athlete.adapter

import android.view.ViewGroup
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.ui.athlete.AthleteAdapterData
import ee.mtiidla.swimresult.ui.athlete.AthleteAdapterData.EntryItem
import ee.mtiidla.swimresult.ui.resultsummary.EntrySummaryView
import ee.mtiidla.swimresult.util.ViewAdapterDelegate
import ee.mtiidla.swimresult.util.inflateView

class AthleteEntrySummaryAdapterDelegate :
    ViewAdapterDelegate<EntryItem, AthleteAdapterData, EntrySummaryView>() {

    override fun createView(parent: ViewGroup): EntrySummaryView = inflateView(parent, R.layout.list_item_entry_summary)

    override fun bindItem(
        item: EntryItem,
        view: EntrySummaryView,
        payloads: List<Any>
    ) {
       view.bindEntrySummary(item.entry)
    }

    override fun isForViewType(
        item: AthleteAdapterData,
        items: MutableList<AthleteAdapterData>,
        position: Int
    ): Boolean = item is EntryItem
}