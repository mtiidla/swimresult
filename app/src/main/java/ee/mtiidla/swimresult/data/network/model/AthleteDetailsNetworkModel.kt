package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AthleteDetailsNetworkModel(
    val id: String,
    val swrid: String,
    val fullname: String,
    val gender: String,
    val nation: String,
    val age: Int,
    val birthdate: String,
    val clubid: String,
    val clubname: String,
    val entries: List<EntrySummaryNetworkModel>,
    val results: List<ResultSummaryNetworkModel>,
    val lastupdate: String
)