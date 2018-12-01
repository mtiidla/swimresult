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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import javax.inject.Inject

class CompetitorNetworkService @Inject constructor(
    private val restApi: RestApi,
    private val athleteMapper: AthleteNetworkMapper,
    private val clubMapper: ClubNetworkMapper,
    private val athleteDetailsMapper: AthleteDetailsNetworkMapper,
    private val clubDetailsMapper: ClubDetailsNetworkMapper
) : CompetitorService {
    override fun athletes(meetId: Long): Deferred<List<Athlete>> =
        CoroutineScope(Dispatchers.IO).async {

            val athletes = restApi.getAthletes(meetId).await()

            return@async athleteMapper.map(athletes)
        }

    override fun clubs(meetId: Long): Deferred<List<Club>> =
        CoroutineScope(Dispatchers.IO).async {

            val clubs = restApi.getClubs(meetId).await()

            return@async clubMapper.map(clubs)
        }

    override fun athlete(meetId: Long, athleteId: Long): Deferred<AthleteDetails> =
        CoroutineScope(Dispatchers.IO).async {

            val athlete = restApi.getAthlete(meetId, athleteId).await()

            return@async athleteDetailsMapper.map(athlete)
        }

    override fun club(meetId: Long, clubId: Long): Deferred<ClubDetails> =
        CoroutineScope(Dispatchers.IO).async {

            val club = restApi.getClub(meetId, clubId).await()

            return@async clubDetailsMapper.map(club)
        }
}