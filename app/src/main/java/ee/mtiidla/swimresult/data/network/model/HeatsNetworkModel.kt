package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HeatsNetworkModel(
    val id: String,
    val status: Int,
    val lastupdate: String,
    val heats: List<HeatNetworkModel>
)