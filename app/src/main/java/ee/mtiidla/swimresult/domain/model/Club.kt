package ee.mtiidla.swimresult.domain.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Club(
    val id: Long,
    val code: String,
    val name: String,
    val nation: String,
    val region: String,
    val shortname: String,
    val longcode: String
)