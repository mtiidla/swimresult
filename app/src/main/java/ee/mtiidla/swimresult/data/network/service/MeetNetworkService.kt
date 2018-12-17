package ee.mtiidla.swimresult.data.network.service

import ee.mtiidla.swimresult.data.network.RestApi
import ee.mtiidla.swimresult.data.network.mapper.AgeGroupNetworkMapper
import ee.mtiidla.swimresult.data.network.mapper.MeetGroupNetworkMapper
import ee.mtiidla.swimresult.data.network.mapper.MeetNetworkMapper
import ee.mtiidla.swimresult.domain.model.AgeGroup
import ee.mtiidla.swimresult.domain.model.Meet
import ee.mtiidla.swimresult.domain.model.MeetGroup
import ee.mtiidla.swimresult.domain.service.MeetService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import javax.inject.Inject

class MeetNetworkService @Inject constructor(
    private val restApi: RestApi,
    private val meetMapper: MeetNetworkMapper,
    private val meetGroupMapper: MeetGroupNetworkMapper,
    private val ageGroupMapper: AgeGroupNetworkMapper
) : MeetService {

    override suspend fun meets(): List<MeetGroup> {

        val meets = restApi.getMeets().await()

        return meetGroupMapper.map(meets.meetgroups)
    }

    override suspend fun meet(meetId: Long): Meet {

        val meet = restApi.getMeet(meetId).await()

        return meetMapper.map(meet)
    }

    override fun ageGroups(meetId: Long): Deferred<List<AgeGroup>> =
        CoroutineScope(Dispatchers.IO).async {

            val ageGroups = restApi.getAgegroups(meetId).await()

            return@async ageGroupMapper.map(ageGroups.agegroups)
        }
}