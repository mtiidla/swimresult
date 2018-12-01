package ee.mtiidla.swimresult.domain.model

data class ClubDetails(
    val id: Long,
    val name: String,
    val code: String,
    val swrid: String?,
    val athletes: List<ClubAthlete>,
    val entries: List<EntrySummary>,
    val results: List<ResultSummary>
)