package ee.mtiidla.swimresult.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Meet(
    val id: String,
    val city: String,
    val name: String,
    val nation: String,
    val number: String,
    val course: Int,
    val enddate: String,
    val startdate: String,
    val status: Int,
    val lastupdate: String
)