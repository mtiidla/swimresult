package ee.mtiidla.swimresult.ui.athletelist

import android.view.ViewGroup
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.Athlete
import ee.mtiidla.swimresult.ui.athletelist.AthleteListData.AthleteItem
import ee.mtiidla.swimresult.util.ViewAdapterDelegate
import ee.mtiidla.swimresult.util.inflateView

class AthleteAdapterDelegate(listener: (Athlete) -> Unit) :
    ViewAdapterDelegate<AthleteItem, AthleteListData, AthleteView>({ listener.invoke(it.athlete) }) {

    override fun createView(parent: ViewGroup): AthleteView =
        inflateView(parent, R.layout.list_item_athlete)

    override fun bindItem(
        item: AthleteItem,
        view: AthleteView,
        payloads: List<Any>
    ) {
        view.bindAthlete(item.athlete)
    }

    override fun isForViewType(
        item: AthleteListData,
        items: MutableList<AthleteListData>,
        position: Int
    ) = item is AthleteItem
}
