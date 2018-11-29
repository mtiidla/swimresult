package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AgeGroupResultsNetworkModel(
    val id: String,
    val results: List<ResultNetworkModel>
)