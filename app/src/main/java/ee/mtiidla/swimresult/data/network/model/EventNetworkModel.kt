package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EventNetworkModel(
    val id: String,
    val number: Int,
    val stroke: String?,
    val distance: String?,
    val gender: String,
    val isrelay: Boolean,
    val time: String,
    val date: String,
    val round: String
)