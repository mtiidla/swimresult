package ee.mtiidla.swimresult.domain.model

import org.threeten.bp.LocalDate
import org.threeten.bp.ZonedDateTime

data class Meet(
    val id: Long,
    val city: String,
    val name: String,
    val nation: String,
    val number: String?,
    val course: Int,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val status: Int?,
    val lastUpdate: ZonedDateTime,
    val statistic: Statistics?
) {
    data class Statistics(
        val athletes: Int,
        val entries: Int,
        val relays: Int
    )
}