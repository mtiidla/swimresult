package ee.mtiidla.swimresult.data.network.mapper

import ee.mtiidla.swimresult.data.network.model.AgeGroupNetworkModel
import ee.mtiidla.swimresult.domain.model.AgeGroup
import javax.inject.Inject

class AgeGroupNetworkMapper @Inject constructor() :
    NetworkMapper<AgeGroupNetworkModel, AgeGroup> {

    override fun map(item: AgeGroupNetworkModel): AgeGroup = with(item) {
        AgeGroup(
            id = id.toLong(),
            key = key,
            min = min.toInt(),
            max = max.toInt(),
            name = name
        )
    }
}