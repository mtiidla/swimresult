package ee.mtiidla.swimresult.ui.eventinfo

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ee.mtiidla.swimresult.ui.heat.HeatScreen
import ee.mtiidla.swimresult.util.ViewHolderAdapterDelegate

class HeatScreenAdapterDelegate :
    ViewHolderAdapterDelegate<EventInfoData.HeatItem, EventInfoData, HeatScreenAdapterDelegate.HeatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup) = HeatViewHolder(HeatScreen(parent.context))

    override fun onBindViewHolder(
        item: EventInfoData.HeatItem,
        holder: HeatViewHolder,
        payloads: MutableList<Any>
    ) {
        holder.screen.render(item.heatState)
    }

    override fun isForViewType(
        item: EventInfoData,
        items: MutableList<EventInfoData>,
        position: Int
    ): Boolean = item is EventInfoData.HeatItem

    class HeatViewHolder(internal val screen: HeatScreen) :
        RecyclerView.ViewHolder(screen.getRootView()) {
        init {
            val windowWidth = 1080 // TODO: Marko 27.11.2018 real window width
            itemView.layoutParams = RecyclerView.LayoutParams(windowWidth, RecyclerView.LayoutParams.MATCH_PARENT)
        }
    }
}