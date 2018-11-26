package ee.mtiidla.swimresult.ui.clublist

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import ee.mtiidla.swimresult.domain.model.Club
import ee.mtiidla.swimresult.util.IdEqualsDiffCallback

class ClubListAdapter(listener: (Club) -> Unit) :
    AsyncListDifferDelegationAdapter<ClubListData>(
        IdEqualsDiffCallback<ClubListData>(ClubListData::id)
    ) {

    init {
        delegatesManager.addDelegate(ClubAdapterDelegate(listener))
    }

    override fun getItemId(position: Int): Long {
        return items[position].id
    }
}