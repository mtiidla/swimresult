package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResultsNetworkModel(
    val id: String,
    val status: Int,
    val lastupdate: String,
    val agegroups: List<AgeGroupResultsNetworkModel>
)