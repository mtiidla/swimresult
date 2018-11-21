package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ClubAthlete(
    val gender: String,
    val fullname: String,
    val id: String,
    val swrid: String
)