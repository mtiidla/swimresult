package ee.mtiidla.swimresult.ui.athlete.adapter

import android.view.ViewGroup
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.ui.athlete.AthleteData
import ee.mtiidla.swimresult.ui.athlete.AthleteData.ResultItem
import ee.mtiidla.swimresult.ui.athlete.ResultSummaryView
import ee.mtiidla.swimresult.util.ViewAdapterDelegate
import ee.mtiidla.swimresult.util.inflateView

class AthleteResultSummaryAdapterDelegate :
    ViewAdapterDelegate<ResultItem, AthleteData, ResultSummaryView>() {

    override fun createView(parent: ViewGroup): ResultSummaryView = inflateView(parent, R.layout.list_item_result_summary)

    override fun bindItem(
        item: ResultItem,
        view: ResultSummaryView,
        payloads: List<Any>
    ) {
       view.bindResultSummary(item.result)
    }

    override fun isForViewType(
        item: AthleteData,
        items: MutableList<AthleteData>,
        position: Int
    ): Boolean = item is ResultItem
}