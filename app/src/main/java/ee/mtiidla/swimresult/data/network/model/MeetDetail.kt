package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MeetDetail(
    val startdate: String,
    val nation: String,
    val statistic: MeetStatistics,
    val userinfo: String,
    val lastupdate: String,
    val version: String,
    val id: String,
    val course: String,
    val enddate: String,
    val name: String,
    val days: Int,
    val city: String
)