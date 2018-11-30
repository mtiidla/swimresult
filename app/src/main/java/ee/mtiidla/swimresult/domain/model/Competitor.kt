package ee.mtiidla.swimresult.domain.model

sealed class Competitor(val id: Long) {

    data class Athlete(
        val athleteId: Long,
        val athleteName: String,
        val gender: Gender,
        val nation: String,
        val ageGroup: String,
        val swrid: String?,
        val clubId: Long,
        val clubName: String,
        val clubCode: String
    ) : Competitor(athleteId)

    data class Club(
        val clubId: Long,
        val clubName: String,
        val clubCode: String,
        val nation: String,
        val teamNumber: String,
        val ageText: String,
        val athletes: List<ClubAthlete>
    ) : Competitor(clubId)
}