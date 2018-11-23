package ee.mtiidla.swimresult.data.network.service

import ee.mtiidla.swimresult.data.network.model.MeetDetail
import ee.mtiidla.swimresult.data.network.model.Meetgroup
import kotlinx.coroutines.Deferred

interface MeetService {
    fun meets() : Deferred<List<Meetgroup>>
    fun meet(meetId : Long): Deferred<MeetDetail>
}