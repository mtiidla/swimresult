package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResultNetworkModel(
    val gender: String,
    val nation: String,
    val medal: Int?,
    val heatinfo: HeatInfoNetworkModel?,
    val clubtext: String,
    val clubcode: String,
    val athleteid: String,
    val splits: Map<String, String>?,
    val entrytime: String,
    val agetext: String,
    val heatid: String,
    val swrid: String?,
    val lane: Int,
    val swimtime: String,
    val info: String,
    val clubid: String,
    val nametext: String,
    val place: Int,
    val diff: String?
)