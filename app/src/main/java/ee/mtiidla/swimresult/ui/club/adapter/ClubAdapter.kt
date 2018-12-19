package ee.mtiidla.swimresult.ui.club.adapter

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import ee.mtiidla.swimresult.ui.club.ClubAdapterData
import ee.mtiidla.swimresult.util.IdEqualsDiffCallback

class ClubAdapter : AsyncListDifferDelegationAdapter<ClubAdapterData>(
    IdEqualsDiffCallback<ClubAdapterData>(ClubAdapterData::id)
) {

    init {
        delegatesManager.addDelegate(ClubDetailsAdapterDelegate())
        delegatesManager.addDelegate(ClubResultSummaryAdapterDelegate())
        delegatesManager.addDelegate(ClubEntrySummaryAdapterDelegate())
        delegatesManager.addDelegate(ResultHeaderAdapterDelegate())
        delegatesManager.addDelegate(EntryHeaderAdapterDelegate())
    }

    override fun getItemId(position: Int): Long {
        return items[position].id
    }
}