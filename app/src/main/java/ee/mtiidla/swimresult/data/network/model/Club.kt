package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Club(
    val nation: String,
    val shortname: String,
    val region: String,
    val longcode: String,
    val id: String,
    val name: String,
    val code: String
)