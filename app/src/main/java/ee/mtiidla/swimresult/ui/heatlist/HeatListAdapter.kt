package ee.mtiidla.swimresult.ui.heatlist

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import ee.mtiidla.swimresult.util.IdEqualsDiffCallback

class HeatListAdapter :
    AsyncListDifferDelegationAdapter<HeatListData>(IdEqualsDiffCallback<HeatListData>(HeatListData::id)) {

    init {
        delegatesManager.addDelegate(HeatAdapterDelegate())
    }

    override fun getItemId(position: Int): Long {
        return items[position].id
    }
}