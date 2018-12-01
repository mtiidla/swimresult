package ee.mtiidla.swimresult.data.network.mapper

import ee.mtiidla.swimresult.data.network.model.ClubDetailsNetworkModel
import ee.mtiidla.swimresult.domain.model.ClubDetails
import javax.inject.Inject

class ClubDetailsNetworkMapper @Inject constructor(
    private val clubAthleteMapper: ClubAthleteNetworkMapper,
    private val entryMapper: EntrySummaryNetworkMapper,
    private val resultMapper: ResultSummaryNetworkMapper
) : NetworkMapper<ClubDetailsNetworkModel, ClubDetails> {

    override fun map(item: ClubDetailsNetworkModel): ClubDetails = with(item) {
        ClubDetails(
            id = id.toLong(),
            name = name,
            code = code,
            swrid = swrid,
            athletes = clubAthleteMapper.map(athletes),
            entries = entryMapper.map(entries),
            results = resultMapper.map(results)
        )
    }
}