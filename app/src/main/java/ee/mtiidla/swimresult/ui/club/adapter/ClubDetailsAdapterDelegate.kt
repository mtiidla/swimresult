package ee.mtiidla.swimresult.ui.club.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.ui.club.ClubAdapterData
import ee.mtiidla.swimresult.ui.club.ClubAdapterData.ClubItem
import ee.mtiidla.swimresult.util.ViewHolderAdapterDelegate
import ee.mtiidla.swimresult.util.inflateView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_club_details.*

class ClubDetailsAdapterDelegate :
    ViewHolderAdapterDelegate<ClubItem, ClubAdapterData, ClubDetailsAdapterDelegate.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder =
        ViewHolder(
            inflateView(parent, R.layout.list_item_club_details)
        )

    override fun isForViewType(
        item: ClubAdapterData,
        items: MutableList<ClubAdapterData>,
        position: Int
    ): Boolean = item is ClubItem

    override fun onBindViewHolder(
        item: ClubItem,
        holder: ViewHolder,
        payloads: MutableList<Any>
    ) {
        holder.bindClub(item)
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        fun bindClub(club: ClubItem) {
            clubNameView.text = club.club.toString()
        }

    }
}