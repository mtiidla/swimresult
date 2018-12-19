package ee.mtiidla.swimresult.ui.athlete.adapter

import android.view.ViewGroup
import android.widget.TextView
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.ui.athlete.AthleteData
import ee.mtiidla.swimresult.ui.athlete.AthleteData.ResultHeaderItem
import ee.mtiidla.swimresult.util.ViewAdapterDelegate
import ee.mtiidla.swimresult.util.inflateView

class ResultHeaderAdapterDelegate :
    ViewAdapterDelegate<ResultHeaderItem, AthleteData, TextView>() {
    override fun createView(parent: ViewGroup): TextView = inflateView(parent, R.layout.list_item_athlete_result_header)

    override fun bindItem(item: ResultHeaderItem, view: TextView, payloads: List<Any>) {
        // do nothing, static layout
    }

    override fun isForViewType(
        item: AthleteData,
        items: MutableList<AthleteData>,
        position: Int
    ): Boolean = item is ResultHeaderItem
}