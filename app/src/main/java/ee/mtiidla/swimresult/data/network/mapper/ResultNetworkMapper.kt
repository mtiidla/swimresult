package ee.mtiidla.swimresult.data.network.mapper

import ee.mtiidla.swimresult.data.network.model.ResultNetworkModel
import ee.mtiidla.swimresult.domain.model.Result
import ee.mtiidla.swimresult.domain.model.Split
import ee.mtiidla.swimresult.util.whenNotNull
import javax.inject.Inject

class ResultNetworkMapper @Inject constructor() : NetworkMapper<ResultNetworkModel, Result> {

    override fun map(item: ResultNetworkModel): Result = with(item) {
        Result(
            swrid = swrid,
            athleteId = athleteid.toLong(),
            athleteName = nametext,
            gender = mapGender(gender),
            nation = nation,
            clubId = clubid.toLong(),
            clubName = clubtext,
            clubCode = clubcode,
            entryTime = entrytime,
            heatId = heatid.toLong(),
            heatinfo = whenNotNull(heatinfo) { mapHeatInfo(it) },
            lane = lane,
            ageGroup = agetext,
            splits = mapSplits(splits),
            swimTime = swimtime,
            place = place,
            diff = diff,
            info = info,
            medal = medal
        )
    }

    private fun mapSplits(splits: Map<String, String>?): List<Split>? {
        return splits?.map { (distance, time) -> Split(distance, time) }
    }
}