package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Heats(
    val status: Int,
    val lastupdate: String,
    val heats: List<Heat>,
    val id: String
) {
    @JsonClass(generateAdapter = true)
    data class Heat(
        val heatinfo: Heatinfo,
        val status: Int,
        val id: String,
        val entries: List<Entry>,
        val time: String,
        val code: String
    ) {
        @JsonClass(generateAdapter = true)
        data class Entry(
            val gender: String,
            val nation: String,
            val clubtext: String,
            val clubcode: String,
            val athleteid: String,
            val entrytime: String,
            val agetext: String,
            val swrid: String,
            val lane: Int,
            val clubid: String,
            val nametext: String
        )
    }
}