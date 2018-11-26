package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SessionNetworkModel(
    val name: String,
    val day: Int,
    val time: String,
    val date: String,
    val number: Int,
    val course: String,
    val events: List<SessionEventNetworkModel>
)