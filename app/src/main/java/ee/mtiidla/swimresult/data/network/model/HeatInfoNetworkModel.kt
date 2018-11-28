package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HeatInfoNetworkModel(
    val key: String,
    val code: String
)