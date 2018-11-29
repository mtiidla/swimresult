package ee.mtiidla.swimresult.domain.model

import org.threeten.bp.LocalTime

data class Heat(
    val id: Long,
    val heatInfo: HeatInfo,
    val status: Int,
    val entries: List<Entry>,
    val time: LocalTime?,
    val code: String
)