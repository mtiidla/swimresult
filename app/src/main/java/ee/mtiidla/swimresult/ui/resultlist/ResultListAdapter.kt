package ee.mtiidla.swimresult.ui.resultlist

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import ee.mtiidla.swimresult.domain.model.Result
import ee.mtiidla.swimresult.util.IdEqualsDiffCallback

class ResultListAdapter(listener: (Result) -> Unit) :
    AsyncListDifferDelegationAdapter<ResultListData>(
        IdEqualsDiffCallback<ResultListData>(
            ResultListData::id
        )
    ) {

    init {
        delegatesManager.addDelegate(ResultAdapterDelegate(listener))
        delegatesManager.addDelegate(AgeGroupAdapterDelegate())
    }

    override fun getItemId(position: Int): Long {
        return items[position].id
    }
}