package ee.mtiidla.swimresult.domain.model

import org.threeten.bp.LocalDate
import org.threeten.bp.LocalTime

data class Event(
    val id: Long,
    val number: Int,
    val stroke: Stroke,
    val distance: String?,
    val styleName: String?,
    val gender: Gender,
    val relay: Boolean,
    val time: LocalTime?,
    val date: LocalDate?,
    val round: Round,
    val status: Status? = null
) {
    enum class Status {
        INVITATION, ENTRIES, SEEDED, ONGOING, FINISHED, UNKNOWN
    }
    enum class Round {
        TIMED_FINAL, PRELIM, FINAL, UNKNOWN
    }
}