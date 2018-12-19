package ee.mtiidla.swimresult.ui.athlete.adapter

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import ee.mtiidla.swimresult.ui.athlete.AthleteData
import ee.mtiidla.swimresult.util.IdEqualsDiffCallback

class AthleteAdapter : AsyncListDifferDelegationAdapter<AthleteData>(
    IdEqualsDiffCallback<AthleteData>(AthleteData::id)
) {

    init {
        delegatesManager.addDelegate(AthleteDetailsAdapterDelegate())
        delegatesManager.addDelegate(AthleteResultSummaryAdapterDelegate())
        delegatesManager.addDelegate(AthleteEntrySummaryAdapterDelegate())
        delegatesManager.addDelegate(ResultHeaderAdapterDelegate())
        delegatesManager.addDelegate(EntryHeaderAdapterDelegate())
    }

    override fun getItemId(position: Int): Long {
        return items[position].id
    }
}