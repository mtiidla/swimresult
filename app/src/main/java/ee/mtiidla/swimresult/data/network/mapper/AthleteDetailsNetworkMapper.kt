package ee.mtiidla.swimresult.data.network.mapper

import ee.mtiidla.swimresult.data.network.model.AthleteDetailsNetworkModel
import ee.mtiidla.swimresult.domain.model.AthleteDetails
import javax.inject.Inject

class AthleteDetailsNetworkMapper @Inject constructor(
    private val entryMapper: EntrySummaryNetworkMapper,
    private val resultMapper: ResultSummaryNetworkMapper
) : NetworkMapper<AthleteDetailsNetworkModel, AthleteDetails> {

    override fun map(item: AthleteDetailsNetworkModel): AthleteDetails = with(item) {
        AthleteDetails(
            id = id.toLong(),
            swrid = swrid,
            fullName = fullname,
            gender = mapGender(gender),
            nation = nation,
            age = age,
            birthDate = mapDate(birthdate),
            clubId = clubid.toLong(),
            clubName = clubname,
            entries = entryMapper.map(entries),
            results = resultMapper.map(results)
        )
    }
}