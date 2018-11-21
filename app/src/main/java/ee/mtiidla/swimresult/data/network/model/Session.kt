package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Session(
    val day: Int,
    val events: List<SessionEvent>,
    val course: String,
    val number: Int,
    val time: String,
    val name: String,
    val date: String
)