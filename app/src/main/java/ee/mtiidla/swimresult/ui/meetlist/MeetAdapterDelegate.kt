package ee.mtiidla.swimresult.ui.meetlist

import android.view.ViewGroup
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.Meet
import ee.mtiidla.swimresult.ui.meet.MeetView
import ee.mtiidla.swimresult.ui.meetlist.MeetListData.MeetItem
import ee.mtiidla.swimresult.util.ViewAdapterDelegate
import ee.mtiidla.swimresult.util.inflateView

class MeetAdapterDelegate(private val listener: (Meet) -> Unit) :
    ViewAdapterDelegate<MeetItem, MeetListData, MeetView>({ listener.invoke(it.meet) }) {

    override fun createView(parent: ViewGroup): MeetView =
        inflateView(parent, R.layout.list_item_meet)

    override fun bindItem(item: MeetItem, view: MeetView, payloads: List<Any>) {
        view.bindMeet(item.meet)
    }

    override fun isForViewType(
        item: MeetListData,
        items: MutableList<MeetListData>,
        position: Int
    ) = item is MeetItem
}