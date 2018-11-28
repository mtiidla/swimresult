package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EntriesNetworkModel(
    val status: Int,
    val lastupdate: String,
    val id: String,
    val entries: List<EntryNetworkModel>
)