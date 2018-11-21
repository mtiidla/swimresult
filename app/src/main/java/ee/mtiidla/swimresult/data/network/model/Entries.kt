package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Entries(
    val status: Int,
    val lastupdate: String,
    val id: String,
    val entries: List<AthleteEntry>
) {
    @JsonClass(generateAdapter = true)
    data class AthleteEntry(
        val gender: String,
        val nation: String,
        val clubtext: String,
        val clubcode: String,
        val athleteid: String,
        val entrytime: String,
        val agetext: String,
        val swrid: String,
        val clubid: String,
        val nametext: String,
        val place: Int,
        val status: String,
        val entrystatus: String
    )
}