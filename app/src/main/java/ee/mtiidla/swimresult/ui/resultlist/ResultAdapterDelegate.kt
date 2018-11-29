package ee.mtiidla.swimresult.ui.resultlist

import android.view.ViewGroup
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.ui.resultlist.ResultListData.ResultItem
import ee.mtiidla.swimresult.util.ViewAdapterDelegate
import ee.mtiidla.swimresult.util.inflateView

class ResultAdapterDelegate : ViewAdapterDelegate<ResultItem, ResultListData, ResultView>() {

    override fun createView(parent: ViewGroup): ResultView =
        inflateView(parent, R.layout.list_item_result)

    override fun bindItem(item: ResultItem, view: ResultView, payloads: List<Any>) {
        view.bindResult(item.result)
    }

    override fun isForViewType(
        item: ResultListData,
        items: MutableList<ResultListData>,
        position: Int
    ): Boolean = item is ResultItem
}