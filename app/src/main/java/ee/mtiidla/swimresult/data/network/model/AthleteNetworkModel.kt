package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AthleteNetworkModel(
    val id: String,
    val gender: String,
    val lastname: String,
    val fullname: String,
    val swrid: String?,
    val clubid: String
)