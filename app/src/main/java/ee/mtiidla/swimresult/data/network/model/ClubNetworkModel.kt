package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ClubNetworkModel(
    val id: String,
    val code: String,
    val name: String,
    val nation: String,
    val region: String,
    val shortname: String,
    val longcode: String
)