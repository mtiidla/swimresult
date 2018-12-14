package ee.mtiidla.swimresult.domain.model

import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter

data class DateRange(
    val start: LocalDate,
    val end: LocalDate
) {
    fun format(formatter: DateTimeFormatter): String =
        if (start == end) {
            start.format(formatter)
        } else {
            "${start.format(formatter)} - ${end.format(formatter)}"
        }
}