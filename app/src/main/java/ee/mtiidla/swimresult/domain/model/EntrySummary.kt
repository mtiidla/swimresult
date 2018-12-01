package ee.mtiidla.swimresult.domain.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EntrySummary(
    val eventId: Long,
    val heatId: Long,
    val heatInfo: HeatInfo,
    val entryTime: String,
    val lane: Int,
    val teamNumber: String?,
    val athletes: List<ClubAthlete>?
)