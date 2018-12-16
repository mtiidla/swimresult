package ee.mtiidla.swimresult.ui.event

import android.content.res.Resources
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.Event
import ee.mtiidla.swimresult.domain.model.Gender
import ee.mtiidla.swimresult.domain.model.Stroke

class EventDisplayer(val resources: Resources) {

    fun getSwimStyle(event: Event): String = with(event) {
        styleName ?: string(getStroke(stroke, relay))
    }

    fun getTitle(event: Event): String = with(event) {
        val gender = string(getGender(gender))
        val style = getSwimStyle(event)
        return listOf("$number.", "$gender,", distance, style).filterNot { it.isNullOrBlank() }.joinToString(" ")
    }

    @StringRes
    fun getGender(gender: Gender): Int = when (gender) {
        Gender.MALE -> R.string.event_gender_male
        Gender.YOUTH_MALE -> R.string.event_gender_youth_male
        Gender.FEMALE -> R.string.event_gender_female
        Gender.YOUTH_FEMALE -> R.string.event_gender_youth_female
        Gender.MIX -> R.string.event_gender_mix
        Gender.ALL -> R.string.event_gender_all
        Gender.OTHER -> R.string.event_gender_other
    }

    @StringRes
    fun getRound(round: Event.Round): Int = when (round) {
        Event.Round.TIMED_FINAL -> R.string.round_timed_final
        Event.Round.PRELIM -> R.string.round_prelim
        Event.Round.FINAL -> R.string.round_final
        Event.Round.UNKNOWN -> R.string.round_unknown
    }

    @ColorRes
    fun getStatusColorRes(status: Event.Status): Int = when (status) {
        Event.Status.INVITATION -> R.color.status_invitation
        Event.Status.ENTRIES -> R.color.status_entries
        Event.Status.SEEDED -> R.color.status_seeded
        Event.Status.ONGOING -> R.color.status_ongoing
        Event.Status.FINISHED -> R.color.status_finished
        Event.Status.UNKNOWN -> R.color.status_invitation
    }

    @StringRes
    fun getStroke(stroke: Stroke, isRelay: Boolean = false): Int = when (stroke) {
        Stroke.FREE -> R.string.stroke_free
        Stroke.BACK -> R.string.stroke_back
        Stroke.BREAST -> R.string.stroke_breast
        Stroke.FLY -> R.string.stroke_fly
        Stroke.IM -> if (isRelay) R.string.stroke_medley else R.string.stroke_im
        Stroke.OTHER -> R.string.stroke_other
    }

    private fun string(stringRes: Int): String = resources.getString(stringRes)
}