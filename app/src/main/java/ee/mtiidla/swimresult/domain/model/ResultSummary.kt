package ee.mtiidla.swimresult.domain.model

class ResultSummary (
    val eventId: Long,
    val ageGroupId: Long,
    val medal: Int?,
    val heatInfo: HeatInfo,
    val splits: List<Split>?,
    val entryTime: String,
    val heatId: Long,
    val lane: Int,
    val swimTime: String,
    val info: String,
    val place: Int,
    val athletes: List<ClubAthlete>?,
    val teamNumber: String?
)