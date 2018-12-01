package ee.mtiidla.swimresult.data.network.mapper

import ee.mtiidla.swimresult.data.network.model.HeatInfoNetworkModel
import ee.mtiidla.swimresult.domain.model.Gender
import ee.mtiidla.swimresult.domain.model.HeatInfo
import ee.mtiidla.swimresult.domain.model.Split
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

internal fun mapHeatInfo(heatInfo: HeatInfoNetworkModel) = with(heatInfo) {
    HeatInfo(key, code)
}

internal fun mapSplits(splits: Map<String, String>?): List<Split>? {
    return splits?.map { (distance, time) -> Split(distance, time) }
}

internal fun mapTime(time: String): LocalTime? = if (time.isBlank()) null else LocalTime.parse(time)

internal fun mapDate(date: String): LocalDate = LocalDate.parse(date)

internal fun mapDateSafe(date: String): LocalDate? = if (date.isBlank()) null else LocalDate.parse(date)

internal fun mapUtcDateTime(datetime: String): ZonedDateTime =
    LocalDateTime.parse(datetime).atZone(ZoneOffset.UTC)