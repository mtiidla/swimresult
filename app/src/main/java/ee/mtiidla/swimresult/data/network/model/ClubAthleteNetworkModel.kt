package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ClubAthleteNetworkModel(
    val id: String,
    val gender: String?,
    val fullname: String,
    val swrid: String?
)