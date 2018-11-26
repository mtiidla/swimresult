package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SessionEventNetworkModel(
    val status: Int,
    val id: String
)