package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Event(
    val gender: String,
    val eid: String,
    val stroke: String,
    val isrelay: Boolean,
    val distance: String,
    val id: String,
    val number: Int,
    val time: String,
    val date: String,
    val round: String
)