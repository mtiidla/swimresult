package ee.mtiidla.swimresult.ui.resultlist

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import ee.mtiidla.swimresult.util.IdEqualsDiffCallback

class ResultListAdapter :
    AsyncListDifferDelegationAdapter<ResultListData>(
        IdEqualsDiffCallback<ResultListData>(
            ResultListData::id
        )
    ) {

    init {
        delegatesManager.addDelegate(ResultAdapterDelegate())
        delegatesManager.addDelegate(AgeGroupAdapterDelegate())
    }

    override fun getItemId(position: Int): Long {
        return items[position].id
    }
}