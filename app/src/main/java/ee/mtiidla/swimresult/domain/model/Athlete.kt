package ee.mtiidla.swimresult.domain.model

data class Athlete(
    val id: Long,
    val gender: Gender,
    val lastname: String,
    val fullname: String,
    val swrid: String?,
    val clubid: Long
)