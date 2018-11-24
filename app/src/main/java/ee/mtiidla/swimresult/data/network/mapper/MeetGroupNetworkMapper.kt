package ee.mtiidla.swimresult.data.network.mapper

import ee.mtiidla.swimresult.data.network.model.MeetGroupNetworkModel
import ee.mtiidla.swimresult.domain.model.Country
import ee.mtiidla.swimresult.domain.model.MeetGroup
import javax.inject.Inject

class MeetGroupNetworkMapper @Inject constructor(private val meetMapper: MeetNetworkMapper) :
    NetworkMapper<MeetGroupNetworkModel, MeetGroup> {

    override fun map(item: MeetGroupNetworkModel): MeetGroup = with(item) {
        MeetGroup(Country(code, name), meetMapper.map(meets))
    }
}