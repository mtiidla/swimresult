package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Athlete(
    val gender: String,
    val lastname: String,
    val fullname: String,
    val id: String,
    val swrid: String,
    val clubid: String
)