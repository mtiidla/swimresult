package ee.mtiidla.swimresult.data.network.mapper

import ee.mtiidla.swimresult.data.network.model.MeetNetworkModel
import ee.mtiidla.swimresult.domain.model.Meet
import javax.inject.Inject

class MeetNetworkMapper @Inject constructor() : NetworkMapper<MeetNetworkModel, Meet> {
    override fun map(item: MeetNetworkModel): Meet = with(item) {
        Meet(
            id = id.toLong(),
            city = city,
            name = name,
            nation = nation,
            number = number,
            startDate = mapDate(startdate),
            endDate = mapDate(enddate),
            course = course,
            status = status,
            lastUpdate = mapUtcDateTime(lastupdate),
            statistic = null
        )
    }
}