package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AgeGroupNetworkModel(
    val id: String,
    val key: String,
    val min: String,
    val max: String,
    val name: String?
)