package ee.mtiidla.swimresult.data.network.service

import ee.mtiidla.swimresult.data.network.RestApi
import ee.mtiidla.swimresult.data.network.mapper.MeetGroupNetworkMapper
import ee.mtiidla.swimresult.data.network.mapper.MeetNetworkMapper
import ee.mtiidla.swimresult.domain.model.MeetGroup
import ee.mtiidla.swimresult.domain.network.service.MeetService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import javax.inject.Inject

class MeetNetworkService @Inject constructor(
    private val restApi: RestApi,
    private val meetMapper: MeetNetworkMapper,
    private val meetGroupMapper: MeetGroupNetworkMapper
) : MeetService {

    override fun meets(): Deferred<List<MeetGroup>> = CoroutineScope(Dispatchers.IO).async {

        val meets = restApi.getMeets().await()

        return@async meetGroupMapper.map(meets.meetgroups)

    }

    override fun meet(meetId: Long) = CoroutineScope(Dispatchers.IO).async {

        val meet = restApi.getMeet(meetId).await()

        return@async meetMapper.map(meet)
    }
}