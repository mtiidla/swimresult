package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ClubDetailsNetworkModel(
    val id: String,
    val name: String,
    val code: String,
    val swrid: String?,
    val athletes: List<ClubAthleteNetworkModel>,
    val entries: List<EntrySummaryNetworkModel>,
    val results: List<ResultSummaryNetworkModel>,
    val lastupdate: String
)