package ee.mtiidla.swimresult.ui.meet

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.annotation.ColorRes
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.Course
import ee.mtiidla.swimresult.domain.model.DateRange
import ee.mtiidla.swimresult.domain.model.Meet
import ee.mtiidla.swimresult.util.color
import ee.mtiidla.swimresult.util.string
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
        meetSubtitleView.text = listOf(city, getDisplayableCourse(course), date)
            .filter { it.isNotBlank() }
            .joinToString(" • ")
        meetStatusView.setColorFilter(color(getStatusColorRes(status!!)))
    }

    @ColorRes
    private fun getStatusColorRes(status: Meet.Status): Int = when (status) {
        Meet.Status.INVITATION -> R.color.status_invitation
        Meet.Status.SEEDED -> R.color.status_seeded
        Meet.Status.ONGOING -> R.color.status_ongoing
        Meet.Status.FINISHED -> R.color.status_finished
        Meet.Status.UNKNOWN -> R.color.status_invitation
    }

    private fun getDisplayableCourse(course: Course): String = when (course) {
        Course.LCM -> string(R.string.lcm)
        Course.SCM -> string(R.string.scm)
        Course.OTHER -> ""
    }
}