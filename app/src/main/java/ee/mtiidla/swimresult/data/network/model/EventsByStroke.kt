package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EventsByStroke(
    val lastupdate: String,
    val eventgroups: List<Eventgroup>
) {
    @JsonClass(generateAdapter = true)
    data class Eventgroup(
        val gender: String,
        val stroke: String,
        val events: List<StrokeEvent>
    ) {
        @JsonClass(generateAdapter = true)
        data class StrokeEvent(
            val status: Int,
            val id: String
        )
    }
}