package ee.mtiidla.swimresult.data.network

import ee.mtiidla.swimresult.data.network.model.AgeGroupsNetworkModel
import ee.mtiidla.swimresult.data.network.model.AthleteDetails
import ee.mtiidla.swimresult.data.network.model.AthleteNetworkModel
import ee.mtiidla.swimresult.data.network.model.ClubNetworkModel
import ee.mtiidla.swimresult.data.network.model.ClubResults
import ee.mtiidla.swimresult.data.network.model.EntriesNetworkModel
import ee.mtiidla.swimresult.data.network.model.EventsByStroke
import ee.mtiidla.swimresult.data.network.model.EventsNetworkModel
import ee.mtiidla.swimresult.data.network.model.HeatsNetworkModel
import ee.mtiidla.swimresult.data.network.model.MeetNetworkModel
import ee.mtiidla.swimresult.data.network.model.MeetsNetworkModel
import ee.mtiidla.swimresult.data.network.model.ResultsNetworkModel
import ee.mtiidla.swimresult.data.network.model.SessionsNetworkModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface RestApi {

    @GET("index.php?Cmd=Meets")
    fun getMeets(): Deferred<MeetsNetworkModel>

    @GET("meets/{meetId}/main.dat")
    fun getMeet(@Path("meetId") meetId: Long): Deferred<MeetNetworkModel>

    @GET("meets/{meetId}/clubs.dat")
    fun getClubs(@Path("meetId") meetId: Long): Deferred<List<ClubNetworkModel>>

    @GET("meets/{meetId}/athletes.dat")
    fun getAthletes(@Path("meetId") meetId: Long): Deferred<List<AthleteNetworkModel>>

    @GET("meets/{meetId}/events.dat")
    fun getEvents(@Path("meetId") meetId: Long): Deferred<EventsNetworkModel>

    @GET("meets/{meetId}/eventsBySession.dat")
    fun getEventsBySession(@Path("meetId") meetId: Long): Deferred<SessionsNetworkModel>

    @GET("meets/{meetId}/eventsByStroke.dat")
    fun getEventsByStroke(@Path("meetId") meetId: Long): Deferred<EventsByStroke>

    @GET("meets/{meetId}/agegroups.dat")
    fun getAgegroups(@Path("meetId") meetId: Long): Deferred<AgeGroupsNetworkModel>

    @GET("meets/{meetId}/results/{eventId}.dat")
    fun getResults(
        @Path("meetId") meetId: Long,
        @Path("eventId") eventId: Long
    ): Deferred<ResultsNetworkModel>

    @GET("meets/{meetId}/heats/{eventId}.dat")
    fun getHeats(
        @Path("meetId") meetId: Long,
        @Path("eventId") eventId: Long
    ): Deferred<HeatsNetworkModel>

    @GET("meets/{meetId}/entries/{eventId}.dat")
    fun getEntries(
        @Path("meetId") meetId: Long,
        @Path("eventId") eventId: Long
    ): Deferred<EntriesNetworkModel>

    @GET("meets/{meetId}/athletes/{athleteId}.dat")
    fun getAthlete(
        @Path("meetId") meetId: Long,
        @Path("athleteId") athleteId: Long
    ): Deferred<AthleteDetails>

    @GET("meets/{meetId}/clubs/{clubId}.dat")
    fun getClub(
        @Path("meetId") meetId: Long,
        @Path("clubId") clubId: Long
    ): Deferred<ClubResults>
}