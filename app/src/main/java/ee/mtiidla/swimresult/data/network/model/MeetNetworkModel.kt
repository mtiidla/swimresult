package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MeetNetworkModel(
    val id: String,
    val city: String,
    val name: String,
    val nation: String,
    val number: String?,
    val course: Int,
    val startdate: String,
    val enddate: String,
    val status: Int?,
    val lastupdate: String,
    val statistic: MeetStatisticsNetworkModel?
)