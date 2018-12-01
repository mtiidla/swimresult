package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MeetStatisticsNetworkModel(
    val athletes: Int,
    val entries: Int,
    val relays: Int
)