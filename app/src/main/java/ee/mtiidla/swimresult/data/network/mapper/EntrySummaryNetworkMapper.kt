package ee.mtiidla.swimresult.data.network.mapper

import ee.mtiidla.swimresult.data.network.model.EntrySummaryNetworkModel
import ee.mtiidla.swimresult.domain.model.EntrySummary
import ee.mtiidla.swimresult.util.whenNotNull
import javax.inject.Inject

class EntrySummaryNetworkMapper @Inject constructor(
    private val clubAthleteMapper: ClubAthleteNetworkMapper
) : NetworkMapper<EntrySummaryNetworkModel, EntrySummary> {

    override fun map(item: EntrySummaryNetworkModel): EntrySummary = with(item) {
        EntrySummary(
            eventId = eventid.toLong(),
            heatId = heatid.toLong(),
            heatInfo = mapHeatInfo(heatinfo),
            entryTime = entrytime,
            lane = lane,
            teamNumber = teamnumber,
            athletes = whenNotNull(athletes) { clubAthleteMapper.map(it) }
        )
    }
}