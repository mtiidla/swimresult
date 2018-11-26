package ee.mtiidla.swimresult.domain.model

import org.threeten.bp.LocalDate
import org.threeten.bp.LocalTime

data class Session(
    val name: String,
    val day: Int,
    val time: LocalTime,
    val date: LocalDate,
    val number: Int,
    val course: Course,
    val events: List<SessionEvent>
)