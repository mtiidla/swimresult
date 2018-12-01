package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MeetDetailNetworkModel(
    val id: String,
    val city: String,
    val name: String,
    val nation: String,
    val course: String,
    val startdate: String,
    val enddate: String,
    val statistic: MeetStatisticsNetworkModel,
    val days: Int,
    val userinfo: String,
    val lastupdate: String,
    val version: String
)