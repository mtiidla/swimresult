package ee.mtiidla.swimresult.ui.club.adapter

import android.view.ViewGroup
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.ui.club.ClubAdapterData
import ee.mtiidla.swimresult.ui.club.ClubAdapterData.ResultItem
import ee.mtiidla.swimresult.ui.resultsummary.ResultSummaryView
import ee.mtiidla.swimresult.util.ViewAdapterDelegate
import ee.mtiidla.swimresult.util.inflateView

class ClubResultSummaryAdapterDelegate :
    ViewAdapterDelegate<ResultItem, ClubAdapterData, ResultSummaryView>() {

    override fun createView(parent: ViewGroup): ResultSummaryView = inflateView(parent, R.layout.list_item_result_summary)

    override fun bindItem(
        item: ResultItem,
        view: ResultSummaryView,
        payloads: List<Any>
    ) {
       view.bindResultSummary(item.result)
    }

    override fun isForViewType(
        item: ClubAdapterData,
        items: MutableList<ClubAdapterData>,
        position: Int
    ): Boolean = item is ResultItem
}