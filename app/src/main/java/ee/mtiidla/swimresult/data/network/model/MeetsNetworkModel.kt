package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MeetsNetworkModel(
    val version: String,
    val status: String,
    val meetgroups: List<MeetGroupNetworkModel>
)