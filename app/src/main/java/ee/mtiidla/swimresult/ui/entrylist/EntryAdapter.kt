package ee.mtiidla.swimresult.ui.entrylist

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import ee.mtiidla.swimresult.util.IdEqualsDiffCallback

class EntryAdapter :
    AsyncListDifferDelegationAdapter<EntryListData>(
        IdEqualsDiffCallback<EntryListData>(
            EntryListData::id
        )
    ) {

    init {
        delegatesManager.addDelegate(EntryAdapterDelegate())
    }

    override fun getItemId(position: Int): Long {
        return items[position].id
    }
}