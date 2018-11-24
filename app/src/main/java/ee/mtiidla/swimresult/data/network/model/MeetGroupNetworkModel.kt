package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MeetGroupNetworkModel(
    val code: String,
    val name: String,
    val meets: List<MeetNetworkModel>
)