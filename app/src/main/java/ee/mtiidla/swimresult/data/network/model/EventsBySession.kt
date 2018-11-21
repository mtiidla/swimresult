package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EventsBySession(
    val lastupdate: String,
    val sessions: List<Session>
)