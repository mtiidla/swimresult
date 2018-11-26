package ee.mtiidla.swimresult.data.network.mapper

import ee.mtiidla.swimresult.domain.model.Gender
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.LocalTime
import org.threeten.bp.ZoneOffset
import org.threeten.bp.ZonedDateTime

internal fun mapGender(gender: String): Gender = when (gender) {
    "1", "11" -> Gender.MALE
    "2", "12" -> Gender.FEMALE
    "3" -> Gender.MIX
    else -> Gender.OTHER
}

internal fun mapTime(time: String): LocalTime = LocalTime.parse(time)

internal fun mapDate(date: String): LocalDate = LocalDate.parse(date)

internal fun mapUtcDateTime(datetime: String): ZonedDateTime =
    LocalDateTime.parse(datetime).atZone(ZoneOffset.UTC)