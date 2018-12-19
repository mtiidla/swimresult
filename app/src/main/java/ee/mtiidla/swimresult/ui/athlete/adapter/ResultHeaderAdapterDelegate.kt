package ee.mtiidla.swimresult.ui.athlete.adapter

import android.view.ViewGroup
import android.widget.TextView
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.ui.athlete.AthleteAdapterData
import ee.mtiidla.swimresult.ui.athlete.AthleteAdapterData.ResultHeaderItem
import ee.mtiidla.swimresult.util.ViewAdapterDelegate
import ee.mtiidla.swimresult.util.inflateView

class ResultHeaderAdapterDelegate :
    ViewAdapterDelegate<ResultHeaderItem, AthleteAdapterData, TextView>() {
    override fun createView(parent: ViewGroup): TextView = inflateView(parent, R.layout.list_item_result_summary_header)

    override fun bindItem(item: ResultHeaderItem, view: TextView, payloads: List<Any>) {
        // do nothing, static layout
    }

    override fun isForViewType(
        item: AthleteAdapterData,
        items: MutableList<AthleteAdapterData>,
        position: Int
    ): Boolean = item is ResultHeaderItem
}