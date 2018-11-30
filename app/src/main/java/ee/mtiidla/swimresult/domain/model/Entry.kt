package ee.mtiidla.swimresult.domain.model

data class Entry(
    val entryTime: String,
    val lane: Int?,
    val place: Int?,
    val status: String?,
    val entryStatus: String?,
    val competitor: Competitor
)