package ee.mtiidla.swimresult.data.network.service

import ee.mtiidla.swimresult.data.network.RestApi
import ee.mtiidla.swimresult.data.network.mapper.AthleteNetworkMapper
import ee.mtiidla.swimresult.domain.model.Athlete
import ee.mtiidla.swimresult.domain.network.service.AthleteService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import javax.inject.Inject

class AthleteNetworkService @Inject constructor(
    private val restApi: RestApi,
    private val athleteMapper: AthleteNetworkMapper
) : AthleteService {

    override fun athletes(meetId: Long): Deferred<List<Athlete>> =
        CoroutineScope(Dispatchers.IO).async {

            val athletes = restApi.getAthletes(meetId).await()

            return@async athleteMapper.map(athletes)
        }
}