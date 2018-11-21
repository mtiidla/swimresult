package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Meetgroup(
    val code: String,
    val name: String,
    val meets: List<Meet>
)