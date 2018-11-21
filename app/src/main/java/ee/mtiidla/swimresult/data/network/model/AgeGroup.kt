package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AgeGroup(
    val min: String,
    val max: String,
    val key: String,
    val id: String
)