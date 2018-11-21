package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Meets(
    val version: String,
    val status: String,
    val meetgroups: List<Meetgroup>
)