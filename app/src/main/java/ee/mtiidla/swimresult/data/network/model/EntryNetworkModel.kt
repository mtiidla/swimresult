package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EntryNetworkModel(
    val athleteid: String,
    val nametext: String,
    val gender: String,
    val nation: String,
    val clubtext: String,
    val clubcode: String,
    val clubid: String,
    val entrytime: String,
    val agetext: String,
    val swrid: String?,
    val lane: Int?,
    val place: Int?,
    val status: String?,
    val entrystatus: String?
)