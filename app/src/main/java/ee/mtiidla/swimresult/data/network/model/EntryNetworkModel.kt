package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

sealed class EntryNetworkModel {

    @JsonClass(generateAdapter = true)
    data class AthleteEntryNetworkModel(
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
    ) : EntryNetworkModel()

    @JsonClass(generateAdapter = true)
    data class ClubEntryNetworkModel(
        val nametext: String,
        val nation: String,
        val clubcode: String,
        val clubid: String,
        val teamnumber: String,
        val entrytime: String,
        val agetext: String,
        val lane: Int?,
        val place: Int?,
        val status: String?,
        val entrystatus: String?,
        val athletes: List<ClubAthleteNetworkModel>?

    ) : EntryNetworkModel()
}