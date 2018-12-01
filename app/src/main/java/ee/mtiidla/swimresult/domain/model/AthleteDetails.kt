package ee.mtiidla.swimresult.domain.model

import org.threeten.bp.LocalDate

data class AthleteDetails (
    val id: Long,
    val swrid: String,
    val fullName: String,
    val gender: Gender,
    val nation: String,
    val age: Int,
    val birthDate: LocalDate,
    val clubId: Long,
    val clubName: String,
    val entries: List<EntrySummary>,
    val results: List<ResultSummary>
)