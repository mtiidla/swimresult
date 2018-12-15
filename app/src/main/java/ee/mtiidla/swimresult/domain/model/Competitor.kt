package ee.mtiidla.swimresult.domain.model

sealed class Competitor(val id: Long, open val nation: String) {

    data class Athlete(
        val athleteId: Long,
        val athleteName: String,
        val gender: Gender,
        override val nation: String,
        val ageGroup: String,
        val swrid: String?,
        val clubId: Long,
        val clubName: String,
        val clubCode: String
    ) : Competitor(athleteId, nation)

    data class Club(
        val clubId: Long,
        val clubName: String,
        val clubCode: String,
        override val nation: String,
        val teamNumber: String,
        val ageText: String,
        val athletes: List<ClubAthlete>
    ) : Competitor(clubId, nation)
}