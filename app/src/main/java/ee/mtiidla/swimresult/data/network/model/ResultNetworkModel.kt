package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

sealed class ResultNetworkModel {

    @JsonClass(generateAdapter = true)
    data class AthleteResultNetworkModel(
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
    ) : ResultNetworkModel()

    @JsonClass(generateAdapter = true)
    data class ClubResultNetworkModel(
        val nation: String,
        val medal: Int?,
        val heatinfo: HeatInfoNetworkModel?,
        val clubcode: String,
        val teamnumber: String,
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
        val diff: String?,
        val athletes: List<ClubAthleteNetworkModel>
    ) : ResultNetworkModel()
}