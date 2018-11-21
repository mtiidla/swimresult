package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MeetStatistics(
    val relays: Int,
    val entries: Int,
    val athletes: Int
)