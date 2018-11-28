package ee.mtiidla.swimresult.ui.heatlist

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ee.mtiidla.swimresult.ui.heat.HeatScreen
import ee.mtiidla.swimresult.util.ViewHolderAdapterDelegate

class HeatAdapterDelegate :
    ViewHolderAdapterDelegate<HeatListData.HeatItem, HeatListData, HeatAdapterDelegate.HeatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup) = HeatViewHolder(HeatScreen(parent.context))

    override fun onBindViewHolder(
        item: HeatListData.HeatItem,
        holder: HeatViewHolder,
        payloads: MutableList<Any>
    ) {
        holder.screen.render(item.heatState)
    }

    override fun isForViewType(
        item: HeatListData,
        items: MutableList<HeatListData>,
        position: Int
    ): Boolean = item is HeatListData.HeatItem

    class HeatViewHolder(internal val screen: HeatScreen) :
        RecyclerView.ViewHolder(screen.getRootView()) {
        init {
            val windowWidth = 1080 // TODO: Marko 27.11.2018 real window width
            itemView.layoutParams = RecyclerView.LayoutParams(windowWidth, RecyclerView.LayoutParams.MATCH_PARENT)
        }
    }
}