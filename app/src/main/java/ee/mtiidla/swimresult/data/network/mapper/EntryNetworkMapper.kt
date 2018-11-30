package ee.mtiidla.swimresult.data.network.mapper

import ee.mtiidla.swimresult.data.network.model.EntryNetworkModel
import ee.mtiidla.swimresult.domain.model.Competitor
import ee.mtiidla.swimresult.domain.model.Entry
import javax.inject.Inject

class EntryNetworkMapper @Inject constructor(private val clubAthleteMapper: ClubAthleteNetworkMapper) :
    NetworkMapper<EntryNetworkModel, Entry> {

    override fun map(item: EntryNetworkModel): Entry =
        when (item) {
            is EntryNetworkModel.AthleteEntryNetworkModel -> {
                with(item) {
                    Entry(
                        entryTime = entrytime,
                        lane = lane,
                        place = place,
                        status = status,
                        entryStatus = entrystatus,
                        competitor = Competitor.Athlete(
                            athleteId = athleteid.toLong(),
                            athleteName = nametext,
                            gender = mapGender(gender),
                            nation = nation,
                            clubId = clubid.toLong(),
                            clubName = clubtext,
                            clubCode = clubcode,
                            ageGroup = agetext,
                            swrid = swrid
                        )
                    )
                }
            }
            is EntryNetworkModel.ClubEntryNetworkModel -> {
                with(item) {
                    Entry(
                        entryTime = entrytime,
                        lane = lane,
                        place = place,
                        status = status,
                        entryStatus = entrystatus,
                        competitor = Competitor.Club(
                            nation = nation,
                            clubId = clubid.toLong(),
                            clubName = nametext,
                            clubCode = clubcode,
                            teamNumber = teamnumber,
                            ageText = agetext,
                            athletes = clubAthleteMapper.map(athletes)
                        )
                    )
                }
            }
        }
}