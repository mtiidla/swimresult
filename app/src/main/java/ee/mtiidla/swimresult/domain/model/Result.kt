package ee.mtiidla.swimresult.domain.model

data class Result (
    val swrid: String?,
    val athleteId: Long,
    val athleteName: String,
    val gender: Gender,
    val nation: String,
    val clubId: Long,
    val clubName: String,
    val clubCode: String,
    val entryTime: String,
    val heatId: Long,
    val heatinfo: HeatInfo?,
    val lane: Int,
    val ageGroup: String,
    val splits: List<Split>?,
    val swimTime: String,
    val place: Int,
    val diff: String?,
    val info: String,
    val medal: Int?
)