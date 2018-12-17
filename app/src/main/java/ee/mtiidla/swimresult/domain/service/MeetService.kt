package ee.mtiidla.swimresult.domain.service

import ee.mtiidla.swimresult.domain.model.AgeGroup
import ee.mtiidla.swimresult.domain.model.Meet
import ee.mtiidla.swimresult.domain.model.MeetGroup
import kotlinx.coroutines.Deferred

interface MeetService {

    suspend fun meets(): List<MeetGroup>

    suspend fun meet(meetId: Long): Meet

    fun ageGroups(meetId: Long): Deferred<List<AgeGroup>>
}