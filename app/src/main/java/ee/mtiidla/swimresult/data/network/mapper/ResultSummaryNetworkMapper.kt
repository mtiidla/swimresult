package ee.mtiidla.swimresult.data.network.mapper

import ee.mtiidla.swimresult.data.network.model.ResultSummaryNetworkModel
import ee.mtiidla.swimresult.domain.model.ResultSummary
import ee.mtiidla.swimresult.util.whenNotNull
import javax.inject.Inject

class ResultSummaryNetworkMapper @Inject constructor(
    private val clubAthleteMapper: ClubAthleteNetworkMapper
) : NetworkMapper<ResultSummaryNetworkModel, ResultSummary> {

    override fun map(item: ResultSummaryNetworkModel): ResultSummary = with(item) {
        ResultSummary(
            eventId = eventid.toLong(),
            ageGroupId = agegroupid.toLong(),
            medal = medal,
            heatInfo = mapHeatInfo(heatinfo),
            splits = mapSplits(splits),
            entryTime = entrytime,
            heatId = heatid.toLong(),
            lane = lane,
            swimTime = swimtime,
            info = info,
            place = place,
            teamNumber = teamnumber,
            athletes = whenNotNull(athletes) { clubAthleteMapper.map(it) }
        )
    }
}