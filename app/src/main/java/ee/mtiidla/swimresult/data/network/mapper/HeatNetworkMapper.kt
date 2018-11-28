package ee.mtiidla.swimresult.data.network.mapper

import ee.mtiidla.swimresult.data.network.model.HeatNetworkModel
import ee.mtiidla.swimresult.domain.model.Heat
import javax.inject.Inject

class HeatNetworkMapper @Inject constructor(private val entryMapper: EntryNetworkMapper) :
    NetworkMapper<HeatNetworkModel, Heat> {

    override fun map(item: HeatNetworkModel): Heat = with(item) {
        Heat(
            id = id.toLong(),
            heatInfo = mapHeatInfo(heatinfo),
            status = status,
            entries = entryMapper.map(entries),
            time = mapTime(time),
            code = code
        )
    }
}