package ee.mtiidla.swimresult.ui.eventinfo

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ee.mtiidla.swimresult.ui.eventinfo.EventInfoData.ResultListItem
import ee.mtiidla.swimresult.ui.resultlist.ResultListScreen
import ee.mtiidla.swimresult.util.ViewHolderAdapterDelegate

class ResultListScreenAdapterDelegate :
    ViewHolderAdapterDelegate<ResultListItem, EventInfoData, ResultListScreenAdapterDelegate.ResultListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup) =
        ResultListViewHolder(ResultListScreen(parent.context))

    override fun onBindViewHolder(
        item: ResultListItem,
        holder: ResultListViewHolder,
        payloads: MutableList<Any>
    ) {
        holder.screen.render(item.resultListState)
    }

    override fun isForViewType(
        item: EventInfoData,
        items: MutableList<EventInfoData>,
        position: Int
    ): Boolean = item is ResultListItem

    class ResultListViewHolder(internal val screen: ResultListScreen) :
        RecyclerView.ViewHolder(screen.getRootView()) {
        init {
            val windowWidth = 1080 // TODO: Marko 27.11.2018 real window width
            itemView.layoutParams =
                RecyclerView.LayoutParams(windowWidth, RecyclerView.LayoutParams.MATCH_PARENT)
        }
    }
}