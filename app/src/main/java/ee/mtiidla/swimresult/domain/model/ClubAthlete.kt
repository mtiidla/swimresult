package ee.mtiidla.swimresult.domain.model

data class ClubAthlete(
    val swrid: String?,
    val id: Long,
    val fullName: String,
    val gender: Gender?,
    val swimTime: String?
)