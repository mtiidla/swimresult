package ee.mtiidla.swimresult.data.network.mapper

import ee.mtiidla.swimresult.data.network.model.AgeGroupResultsNetworkModel
import ee.mtiidla.swimresult.domain.model.AgeGroupResults
import javax.inject.Inject

class AgeGroupResultNetworkMapper @Inject constructor(private val resultMapper: ResultNetworkMapper) :
    NetworkMapper<AgeGroupResultsNetworkModel, AgeGroupResults> {

    override fun map(item: AgeGroupResultsNetworkModel): AgeGroupResults = with(item) {
        AgeGroupResults(
            id.toLong(),
            resultMapper.map(results)
        )
    }
}