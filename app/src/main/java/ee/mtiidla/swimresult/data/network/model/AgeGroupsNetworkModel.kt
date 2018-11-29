package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AgeGroupsNetworkModel(
    val lastupdate: String,
    val agegroups: List<AgeGroupNetworkModel>
)