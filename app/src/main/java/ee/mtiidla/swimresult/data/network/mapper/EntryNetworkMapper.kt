package ee.mtiidla.swimresult.data.network.mapper

import ee.mtiidla.swimresult.data.network.model.EntryNetworkModel
import ee.mtiidla.swimresult.domain.model.Entry
import javax.inject.Inject

class EntryNetworkMapper @Inject constructor() : NetworkMapper<EntryNetworkModel, Entry> {

    override fun map(item: EntryNetworkModel): Entry = with(item) {
        Entry(
            athleteId = athleteid.toLong(),
            athleteName = nametext,
            gender = mapGender(gender),
            nation = nation,
            clubId = clubid.toLong(),
            clubName = clubtext,
            clubCode = clubcode,
            entryTime = entrytime,
            ageText = agetext,
            swrid = swrid,
            lane = lane,
            place = place,
            status = status,
            entryStatus = entrystatus
        )
    }
}