package ee.mtiidla.swimresult.domain.model

import org.threeten.bp.LocalDate
import org.threeten.bp.LocalTime

data class Event(
    val id: Long,
    val number: Int,
    val stroke: Stroke,
    val distance: String?,
    val gender: Gender,
    val relay: Boolean,
    val time: LocalTime?,
    val date: LocalDate,
    val round: String,
    val status: Int? = null
)