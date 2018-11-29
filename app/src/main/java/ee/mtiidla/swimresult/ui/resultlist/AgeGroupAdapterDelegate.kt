package ee.mtiidla.swimresult.ui.resultlist

import android.view.ViewGroup
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.ui.resultlist.ResultListData.AgeGroupItem
import ee.mtiidla.swimresult.util.ViewAdapterDelegate
import ee.mtiidla.swimresult.util.inflateView

class AgeGroupAdapterDelegate : ViewAdapterDelegate<AgeGroupItem, ResultListData, AgeGroupView>() {

    override fun createView(parent: ViewGroup): AgeGroupView =
        inflateView(parent, R.layout.list_item_age_group)

    override fun bindItem(item: AgeGroupItem, view: AgeGroupView, payloads: List<Any>) {
        view.bindAgeGroup(item.ageGroup)
    }

    override fun isForViewType(
        item: ResultListData,
        items: MutableList<ResultListData>,
        position: Int
    ): Boolean = item is AgeGroupItem
}