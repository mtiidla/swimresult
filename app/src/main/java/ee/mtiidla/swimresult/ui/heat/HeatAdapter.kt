package ee.mtiidla.swimresult.ui.heat

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import ee.mtiidla.swimresult.util.IdEqualsDiffCallback

class HeatAdapter :
    AsyncListDifferDelegationAdapter<HeatLaneListData>(
        IdEqualsDiffCallback<HeatLaneListData>(
            HeatLaneListData::id
        )
    ) {

    init {
        delegatesManager.addDelegate(HeatLaneAdapterDelegate())
    }

    override fun getItemId(position: Int): Long {
        return items[position].id
    }
}