package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ClubResults(
    val results: List<Any>,
    val lastupdate: String,
    val id: String,
    val entries: List<Any>,
    val athletes: List<ClubAthleteNetworkModel>,
    val swrid: String,
    val name: String,
    val code: String
)