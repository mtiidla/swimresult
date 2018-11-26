package ee.mtiidla.swimresult.data.network.mapper

import ee.mtiidla.swimresult.data.network.model.ClubNetworkModel
import ee.mtiidla.swimresult.domain.model.Club
import javax.inject.Inject

class ClubNetworkMapper @Inject constructor() : NetworkMapper<ClubNetworkModel, Club> {

    override fun map(item: ClubNetworkModel): Club = with(item) {
        Club(
            id = id.toLong(),
            code = code,
            name = name,
            nation = nation,
            region = region,
            shortname = shortname,
            longcode = longcode
        )
    }
}