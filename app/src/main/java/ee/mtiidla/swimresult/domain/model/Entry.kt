package ee.mtiidla.swimresult.domain.model

data class Entry(
    val athleteId: Long,
    val athleteName: String,
    val gender: Gender,
    val nation: String,
    val clubId: Long,
    val clubName: String,
    val clubCode: String,
    val entryTime: String,
    val ageText: String,
    val swrid: String?,
    val lane: Int?,
    val place: Int?,
    val status: String?,
    val entryStatus: String?
)