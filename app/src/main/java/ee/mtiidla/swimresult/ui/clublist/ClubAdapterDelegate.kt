package ee.mtiidla.swimresult.ui.clublist

import android.view.ViewGroup
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.Club
import ee.mtiidla.swimresult.ui.clublist.ClubListData.ClubItem
import ee.mtiidla.swimresult.util.ViewAdapterDelegate
import ee.mtiidla.swimresult.util.inflateView

class ClubAdapterDelegate(listener: (Club) -> Unit) :
    ViewAdapterDelegate<ClubItem, ClubListData, ClubView>({ listener.invoke(it.club) }) {

    override fun createView(parent: ViewGroup): ClubView =
        inflateView(parent, R.layout.list_item_club)

    override fun bindItem(
        item: ClubItem,
        view: ClubView,
        payloads: List<Any>
    ) {
        view.bindClub(item.club)
    }

    override fun isForViewType(
        item: ClubListData,
        items: MutableList<ClubListData>,
        position: Int
    ) = item is ClubItem
}
