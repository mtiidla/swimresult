package ee.mtiidla.swimresult.domain.model

data class Result (
    val entryTime: String,
    val heatId: Long,
    val heatInfo: HeatInfo?,
    val lane: Int,
    val splits: List<Split>?,
    val swimTime: String,
    val place: Int,
    val diff: String?,
    val info: String,
    val medal: Int?,
    val competitor: Competitor
)