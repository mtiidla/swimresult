package ee.mtiidla.swimresult.data.network.mapper

import ee.mtiidla.swimresult.data.network.model.AthleteNetworkModel
import ee.mtiidla.swimresult.domain.model.Athlete
import javax.inject.Inject

class AthleteNetworkMapper @Inject constructor() : NetworkMapper<AthleteNetworkModel, Athlete> {

    override fun map(item: AthleteNetworkModel): Athlete = with(item) {
        Athlete(
            id = id.toLong(),
            gender = mapGender(gender),
            lastname = lastname,
            fullname = fullname,
            swrid = swrid,
            clubid = clubid.toLong()
        )
    }
}