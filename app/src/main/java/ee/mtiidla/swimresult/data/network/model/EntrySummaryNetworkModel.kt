package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EntrySummaryNetworkModel(
    val eventid: String,
    val heatid: String,
    val heatinfo: HeatInfoNetworkModel,
    val entrytime: String,
    val lane: Int,
    val teamnumber: String?,
    val athletes: List<ClubAthleteNetworkModel>?
)