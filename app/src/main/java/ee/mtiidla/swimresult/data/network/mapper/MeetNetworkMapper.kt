package ee.mtiidla.swimresult.data.network.mapper

import ee.mtiidla.swimresult.data.network.model.MeetNetworkModel
import ee.mtiidla.swimresult.domain.model.Meet
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneOffset
import javax.inject.Inject

class MeetNetworkMapper @Inject constructor() : NetworkMapper<MeetNetworkModel, Meet> {
    override fun map(item: MeetNetworkModel): Meet = with(item) {
        Meet(
            id = id.toLong(),
            city = city,
            name = name,
            nation = nation,
            number = number,
            startDate = LocalDate.parse(startdate),
            endDate = LocalDate.parse(enddate),
            course = course,
            status = status,
            lastUpdate = LocalDateTime.parse(lastupdate).atZone(ZoneOffset.UTC),
            statistic = null
        )
    }
}