package ee.mtiidla.swimresult.data.network.service

import ee.mtiidla.swimresult.data.network.RestApi
import ee.mtiidla.swimresult.data.network.mapper.AthleteDetailsNetworkMapper
import ee.mtiidla.swimresult.data.network.mapper.AthleteNetworkMapper
import ee.mtiidla.swimresult.data.network.mapper.ClubDetailsNetworkMapper
import ee.mtiidla.swimresult.data.network.mapper.ClubNetworkMapper
import ee.mtiidla.swimresult.domain.model.Athlete
import ee.mtiidla.swimresult.domain.model.AthleteDetails
import ee.mtiidla.swimresult.domain.model.Club
import ee.mtiidla.swimresult.domain.model.ClubDetails
import ee.mtiidla.swimresult.domain.service.CompetitorService
import javax.inject.Inject

class CompetitorNetworkService @Inject constructor(
    private val restApi: RestApi,
    private val athleteMapper: AthleteNetworkMapper,
    private val clubMapper: ClubNetworkMapper,
    private val athleteDetailsMapper: AthleteDetailsNetworkMapper,
    private val clubDetailsMapper: ClubDetailsNetworkMapper
) : CompetitorService {

    override suspend fun athletes(meetId: Long): List<Athlete> {

        val athletes = restApi.getAthletes(meetId).await()

        return athleteMapper.map(athletes)
    }

    override suspend fun clubs(meetId: Long): List<Club> {

        val clubs = restApi.getClubs(meetId).await()

        return clubMapper.map(clubs)
    }

    override suspend fun athlete(meetId: Long, athleteId: Long): AthleteDetails {

        val athlete = restApi.getAthlete(meetId, athleteId).await()

        return athleteDetailsMapper.map(athlete)
    }

    override suspend fun club(meetId: Long, clubId: Long): ClubDetails {

        val club = restApi.getClub(meetId, clubId).await()

        return clubDetailsMapper.map(club)
    }
}