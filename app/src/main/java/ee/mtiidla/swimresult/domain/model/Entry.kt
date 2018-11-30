package ee.mtiidla.swimresult.domain.model

data class Entry(
    val entryTime: String,
    val lane: Int?,
    val place: Int?,
    val status: String?,
    val entryStatus: String?,
    val entrant: Entrant
) {
    sealed class Entrant(val id: Long) {

        data class AthleteEntry(
            val athleteId: Long,
            val athleteName: String,
            val gender: Gender,
            val nation: String,
            val ageText: String,
            val swrid: String?,
            val clubId: Long,
            val clubName: String,
            val clubCode: String
        ) : Entrant(athleteId)

        data class ClubEntry(
            val clubId: Long,
            val clubName: String,
            val clubCode: String,
            val nation: String,
            val teamNumber: String,
            val ageText: String,
            val athletes: List<ClubAthlete>
        ) : Entrant(clubId)
    }
}