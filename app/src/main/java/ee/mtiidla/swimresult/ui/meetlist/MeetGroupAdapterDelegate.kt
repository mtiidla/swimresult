package ee.mtiidla.swimresult.ui.meetlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.squareup.picasso.Picasso
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.CountryCodes
import ee.mtiidla.swimresult.ui.meetlist.MeetListData.MeetGroupItem
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_meet_group.*

class MeetGroupAdapterDelegate :
    AbsListItemAdapterDelegate<MeetGroupItem, MeetListData, MeetGroupAdapterDelegate.MeetGroupItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): MeetGroupItemViewHolder =
        MeetGroupItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_meet_group, parent, false)
        )

    override fun onBindViewHolder(
        item: MeetGroupItem,
        holder: MeetGroupItemViewHolder,
        payloads: MutableList<Any>
    ) {
        holder.render(item)
    }

    override fun isForViewType(
        item: MeetListData,
        items: MutableList<MeetListData>,
        position: Int
    ) = item is MeetGroupItem

    class MeetGroupItemViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun render(item: MeetGroupItem) = with(item.meetGroup.country) {
            meetGroupTitleView.text = name
            if (CountryCodes.isValidFinaCountry(code)) {
                val countryCode = CountryCodes.toIso2(code)
                Picasso.get().load("https://www.countryflags.io/$countryCode/flat/64.png")
                    .into(meetGroupFlagView)
            } else {
                // TODO: Marko 04.12.2018 show IOC flag
            }
        }
    }
}