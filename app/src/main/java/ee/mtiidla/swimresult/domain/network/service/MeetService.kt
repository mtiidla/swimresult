package ee.mtiidla.swimresult.domain.network.service

import ee.mtiidla.swimresult.domain.model.Meet
import ee.mtiidla.swimresult.domain.model.MeetGroup
import kotlinx.coroutines.Deferred

interface MeetService {

    fun meets(): Deferred<List<MeetGroup>>

    fun meet(meetId: Long): Deferred<Meet>
}