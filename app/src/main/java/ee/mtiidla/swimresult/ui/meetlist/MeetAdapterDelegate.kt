package ee.mtiidla.swimresult.ui.meetlist

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.Course
import ee.mtiidla.swimresult.domain.model.DateRange
import ee.mtiidla.swimresult.domain.model.Meet
import ee.mtiidla.swimresult.ui.meetlist.MeetAdapterDelegate.MeetItemViewHolder
import ee.mtiidla.swimresult.ui.meetlist.MeetListData.MeetItem
import ee.mtiidla.swimresult.util.notNull
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_meet.*
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle

class MeetAdapterDelegate(private val listener: (Meet) -> Unit) :
    AbsListItemAdapterDelegate<MeetItem, MeetListData, MeetItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup): MeetItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_meet, parent, false)
        return MeetItemViewHolder(view, listener)
    }

    override fun isForViewType(
        item: MeetListData,
        items: MutableList<MeetListData>,
        position: Int
    ) = item is MeetItem

    override fun onBindViewHolder(
        item: MeetItem,
        holder: MeetItemViewHolder,
        payloads: MutableList<Any>
    ) {
        holder.render(item)
    }

    class MeetItemViewHolder(
        override val containerView: View,
        private val listener: (Meet) -> Unit
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        private var item: MeetItem? = null
        private val dateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)

        init {
            itemView.setOnClickListener {
                item.notNull { meetItem ->
                    listener.invoke(meetItem.meet)
                }
            }
        }

        fun render(item: MeetItem) {
            this.item = item
            item.meet.run {
                meetTitleView.text = name
                val date = DateRange(startDate, endDate).format(dateFormatter)
                val pool = getDisplayableCourse(containerView.resources, course)
                meetSubtitleView.text = listOf(city, pool, date)
                    .filter { it.isNotBlank() }
                    .joinToString(" • ")
                meetStatusView.setColorFilter(ContextCompat.getColor(containerView.context, getStatusColorRes(status!!)))
            }
        }

        private fun getStatusColorRes(status: Meet.Status): Int = when (status) {
            Meet.Status.FINISHED -> R.color.status_finished
            Meet.Status.INVITATION -> R.color.status_invitation
            Meet.Status.SEEDED -> R.color.status_seeded
            Meet.Status.ONGOING -> R.color.status_ongoing
            Meet.Status.UNKNOWN -> R.color.status_invitation
        }

        private fun getDisplayableCourse(resources: Resources, course: Course) : String = when (course) {
            Course.LCM -> resources.getString(R.string.lcm)
            Course.SCM -> resources.getString(R.string.scm)
            Course.OTHER -> ""
        }
    }
}