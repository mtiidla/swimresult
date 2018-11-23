package ee.mtiidla.swimresult.data.network.service

import ee.mtiidla.swimresult.data.network.RestApi
import ee.mtiidla.swimresult.data.network.model.Meetgroup
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import javax.inject.Inject

class MeetNetworkService @Inject constructor(private val restApi: RestApi) : MeetService {

    override fun meets() : Deferred<List<Meetgroup>> = CoroutineScope(Dispatchers.IO).async {

        val meets = restApi.getMeets().await()

        return@async meets.meetgroups

    }

    override fun meet(meetId : Long) = restApi.getMeet(meetId)

}