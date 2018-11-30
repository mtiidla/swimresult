package ee.mtiidla.swimresult.data.network.mapper

import ee.mtiidla.swimresult.data.network.model.ClubAthleteNetworkModel
import ee.mtiidla.swimresult.domain.model.ClubAthlete
import ee.mtiidla.swimresult.util.whenNotNull
import javax.inject.Inject

class ClubAthleteNetworkMapper @Inject constructor() :
    NetworkMapper<ClubAthleteNetworkModel, ClubAthlete> {

    override fun map(item: ClubAthleteNetworkModel): ClubAthlete = with(item) {
        ClubAthlete(
            id = id.toLong(),
            swrid = swrid,
            fullName = fullname,
            gender = whenNotNull(gender) { mapGender(it) }
        )
    }
}