package ee.mtiidla.swimresult.data.network.mapper

import ee.mtiidla.swimresult.data.network.model.ResultNetworkModel
import ee.mtiidla.swimresult.domain.model.Competitor
import ee.mtiidla.swimresult.domain.model.Result
import ee.mtiidla.swimresult.util.whenNotNull
import javax.inject.Inject

class ResultNetworkMapper @Inject constructor(private val clubAthleteMapper: ClubAthleteNetworkMapper) :
    NetworkMapper<ResultNetworkModel, Result> {

    override fun map(item: ResultNetworkModel): Result = when (item) {
        is ResultNetworkModel.AthleteResultNetworkModel -> {
            with(item) {
                Result(
                    entryTime = entrytime,
                    heatId = heatid.toLong(),
                    heatInfo = whenNotNull(heatinfo) { mapHeatInfo(it) },
                    lane = lane,
                    splits = mapSplits(splits),
                    swimTime = swimtime,
                    place = place,
                    diff = diff,
                    info = info,
                    medal = medal,
                    competitor = Competitor.Athlete(
                        swrid = swrid,
                        athleteId = athleteid.toLong(),
                        athleteName = nametext,
                        gender = mapGender(gender),
                        nation = nation,
                        clubId = clubid.toLong(),
                        clubName = clubtext,
                        clubCode = clubcode,
                        ageGroup = agetext
                    )
                )
            }
        }
        is ResultNetworkModel.ClubResultNetworkModel -> {
            with(item) {
                Result(
                    entryTime = entrytime,
                    heatId = heatid.toLong(),
                    heatInfo = whenNotNull(heatinfo) { mapHeatInfo(it) },
                    lane = lane,
                    splits = mapSplits(splits),
                    swimTime = swimtime,
                    place = place,
                    diff = diff,
                    info = info,
                    medal = medal,
                    competitor = Competitor.Club(
                        nation = nation,
                        clubId = clubid.toLong(),
                        clubName = nametext,
                        clubCode = clubcode,
                        ageText = agetext,
                        teamNumber = teamnumber,
                        athletes = clubAthleteMapper.map(athletes)
                    )
                )
            }
        }
    }

}