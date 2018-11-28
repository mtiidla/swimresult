package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HeatNetworkModel(
    val id: String,
    val heatinfo: HeatInfoNetworkModel,
    val status: Int,
    val time: String,
    val code: String,
    val entries: List<EntryNetworkModel>
)