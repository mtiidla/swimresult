package ee.mtiidla.swimresult.data.network.mapper

import ee.mtiidla.swimresult.data.network.model.MeetNetworkModel
import ee.mtiidla.swimresult.data.network.model.MeetStatisticsNetworkModel
import ee.mtiidla.swimresult.domain.model.Meet
import ee.mtiidla.swimresult.util.whenNotNull
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
            course = mapCourse(course),
            status = whenNotNull(status) { mapMeetStatus(it) },
            lastUpdate = mapUtcDateTime(lastupdate),
            statistic = whenNotNull(statistic) { mapStatistics(it) }
        )
    }

    private fun mapStatistics(item: MeetStatisticsNetworkModel): Meet.Statistics =
        with(item) {
            Meet.Statistics(
                athletes = athletes,
                entries = entries,
                relays = relays
            )
        }
}