package ee.mtiidla.swimresult.domain.service

import ee.mtiidla.swimresult.domain.model.AgeGroup
import ee.mtiidla.swimresult.domain.model.Meet
import ee.mtiidla.swimresult.domain.model.MeetGroup

interface MeetService {

    suspend fun meets(): List<MeetGroup>

    suspend fun meet(meetId: Long): Meet

    suspend fun ageGroups(meetId: Long): List<AgeGroup>
}