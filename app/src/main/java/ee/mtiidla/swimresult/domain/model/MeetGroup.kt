package ee.mtiidla.swimresult.domain.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MeetGroup(
    val country: Country,
    val meets: List<Meet>
)