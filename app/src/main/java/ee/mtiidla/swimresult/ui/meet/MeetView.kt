package ee.mtiidla.swimresult.ui.meet

import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.Course
import ee.mtiidla.swimresult.domain.model.DateRange
import ee.mtiidla.swimresult.domain.model.Meet
import kotlinx.android.synthetic.main.view_meet.view.*
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle

class MeetView : LinearLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    private val dateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)

    init {
        inflate(context, R.layout.view_meet, this)
        orientation = VERTICAL
    }

    fun bindMeet(meet: Meet) = with(meet) {
        meetTitleView.text = name
        val date = DateRange(startDate, endDate).format(dateFormatter)
        val pool = getDisplayableCourse(resources, course)
        meetSubtitleView.text = listOf(city, pool, date)
            .filter { it.isNotBlank() }
            .joinToString(" • ")
        meetStatusView.setColorFilter(ContextCompat.getColor(context, getStatusColorRes(status!!)))
    }

    private fun getStatusColorRes(status: Meet.Status): Int = when (status) {
        Meet.Status.FINISHED -> R.color.status_finished
        Meet.Status.INVITATION -> R.color.status_invitation
        Meet.Status.SEEDED -> R.color.status_seeded
        Meet.Status.ONGOING -> R.color.status_ongoing
        Meet.Status.UNKNOWN -> R.color.status_invitation
    }

    private fun getDisplayableCourse(resources: Resources, course: Course): String = when (course) {
        Course.LCM -> resources.getString(R.string.lcm)
        Course.SCM -> resources.getString(R.string.scm)
        Course.OTHER -> ""
    }
}