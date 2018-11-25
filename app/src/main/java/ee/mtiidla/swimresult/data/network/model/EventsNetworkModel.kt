package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EventsNetworkModel(
    val lastupdate: String,
    val events: List<EventNetworkModel>
)