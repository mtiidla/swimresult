package ee.mtiidla.swimresult.ui.eventlist

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.Event
import ee.mtiidla.swimresult.domain.model.Gender
import ee.mtiidla.swimresult.domain.model.Stroke
import ee.mtiidla.swimresult.util.color
import ee.mtiidla.swimresult.util.string
import kotlinx.android.synthetic.main.view_event.view.*
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle

class EventView : LinearLayout {

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    // TODO: Marko 15.12.2018 extract date and time formatters to some object
    private val timeFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)

    init {
        inflate(context, R.layout.view_event, this)
        orientation = VERTICAL
    }

    fun bindEvent(event: Event) {
        event.run {
            val gender = string(getDisplayableGender(gender))
            val style = styleName ?: string(getDisplayableStroke(stroke, relay))
            val round = string(getDisplayableRound(round))
            eventNameView.text = listOf("$number.", "$gender,", distance, style).filterNot { it.isNullOrBlank() }.joinToString(" ")
            eventSubtitleView.text = if (time == null) round else "${timeFormatter.format(time)} • $round"
            eventStatusView.setColorFilter(color(getStatusColorRes(status!!)))
        }
    }

    @StringRes
    private fun getDisplayableGender(gender: Gender): Int = when (gender) {
        Gender.MALE -> R.string.event_gender_male
        Gender.YOUTH_MALE -> R.string.event_gender_youth_male
        Gender.FEMALE -> R.string.event_gender_female
        Gender.YOUTH_FEMALE -> R.string.event_gender_youth_female
        Gender.MIX -> R.string.event_gender_mix
        Gender.ALL -> R.string.event_gender_all
        Gender.OTHER -> R.string.event_gender_other
    }

    @StringRes
    private fun getDisplayableRound(round: Event.Round): Int = when (round) {
        Event.Round.TIMED_FINAL -> R.string.round_timed_final
        Event.Round.PRELIM -> R.string.round_prelim
        Event.Round.FINAL -> R.string.round_final
        Event.Round.UNKNOWN -> R.string.round_unknown
    }

    @ColorRes
    private fun getStatusColorRes(status: Event.Status): Int = when (status) {
        Event.Status.INVITATION -> R.color.status_invitation
        Event.Status.ENTRIES -> R.color.status_entries
        Event.Status.SEEDED -> R.color.status_seeded
        Event.Status.ONGOING -> R.color.status_ongoing
        Event.Status.FINISHED -> R.color.status_finished
        Event.Status.UNKNOWN -> R.color.status_invitation
    }

    @StringRes
    private fun getDisplayableStroke(stroke: Stroke, isRelay: Boolean = false): Int = when (stroke) {
        Stroke.FREE -> R.string.stroke_free
        Stroke.BACK -> R.string.stroke_back
        Stroke.BREAST -> R.string.stroke_breast
        Stroke.FLY -> R.string.stroke_fly
        Stroke.IM -> if (isRelay) R.string.stroke_medley else R.string.stroke_im
        Stroke.OTHER -> R.string.stroke_other
    }
}