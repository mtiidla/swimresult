package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AthleteDetails(
    val gender: String,
    val nation: String,
    val age: Int,
    val birthdate: String,
    val results: List<AthleteResult>,
    val lastupdate: String,
    val clubname: String,
    val fullname: String,
    val id: String,
    val entries: List<Any>,
    val swrid: String,
    val clubid: String
)