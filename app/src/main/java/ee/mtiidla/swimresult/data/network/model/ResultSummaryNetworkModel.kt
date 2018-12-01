package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResultSummaryNetworkModel(
    val eventid: String,
    val agegroupid: String,
    val medal: Int?,
    val heatinfo: HeatInfoNetworkModel,
    val splits: Map<String, String>?,
    val entrytime: String,
    val heatid: String,
    val lane: Int,
    val swimtime: String,
    val info: String,
    val place: Int,
    val athletes: List<ClubAthleteNetworkModel>?,
    val teamnumber: String?
)