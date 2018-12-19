package ee.mtiidla.swimresult.ui.athlete.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.ui.athlete.AthleteData
import ee.mtiidla.swimresult.ui.athlete.AthleteData.AthleteItem
import ee.mtiidla.swimresult.util.ViewHolderAdapterDelegate
import ee.mtiidla.swimresult.util.inflateView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_athlete_details.*

class AthleteDetailsAdapterDelegate :
    ViewHolderAdapterDelegate<AthleteItem, AthleteData, AthleteDetailsAdapterDelegate.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder =
        ViewHolder(
            inflateView(parent, R.layout.list_item_athlete_details)
        )

    override fun isForViewType(
        item: AthleteData,
        items: MutableList<AthleteData>,
        position: Int
    ): Boolean = item is AthleteItem

    override fun onBindViewHolder(
        item: AthleteItem,
        holder: ViewHolder,
        payloads: MutableList<Any>
    ) {
        holder.bindAthlete(item)
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        fun bindAthlete(athlete: AthleteItem) {
            athleteNameView.text = athlete.athlete.toString()
        }

    }
}