package ee.mtiidla.swimresult.ui.athletelist

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import ee.mtiidla.swimresult.domain.model.Athlete
import ee.mtiidla.swimresult.util.IdEqualsDiffCallback

class AthleteListAdapter(listener: (Athlete) -> Unit) :
    AsyncListDifferDelegationAdapter<AthleteListData>(
        IdEqualsDiffCallback<AthleteListData>(AthleteListData::id)
    ) {

    init {
        delegatesManager.addDelegate(AthleteAdapterDelegate(listener))
    }

    override fun getItemId(position: Int): Long {
        return items[position].id
    }
}