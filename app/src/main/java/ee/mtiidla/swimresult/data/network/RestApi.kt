package ee.mtiidla.swimresult.data.network

import ee.mtiidla.swimresult.data.network.model.AgeGroup
import ee.mtiidla.swimresult.data.network.model.Athlete
import ee.mtiidla.swimresult.data.network.model.AthleteDetails
import ee.mtiidla.swimresult.data.network.model.Club
import ee.mtiidla.swimresult.data.network.model.ClubResults
import ee.mtiidla.swimresult.data.network.model.Entries
import ee.mtiidla.swimresult.data.network.model.Event
import ee.mtiidla.swimresult.data.network.model.EventsBySession
import ee.mtiidla.swimresult.data.network.model.EventsByStroke
import ee.mtiidla.swimresult.data.network.model.Heats
import ee.mtiidla.swimresult.data.network.model.MeetDetail
import ee.mtiidla.swimresult.data.network.model.Meets
import ee.mtiidla.swimresult.data.network.model.Results
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface RestApi {

    @GET("index.php?Cmd=Meets")
    fun getMeets(): Deferred<Meets>

    @GET("meets/{meetId}/main.dat")
    fun getMeet(@Path("meetId") meetId: Long): Deferred<MeetDetail>

    @GET("meets/{meetId}/clubs.dat")
    fun getClubs(meetId: Long): Deferred<List<Club>>

    @GET("meets/{meetId}/athletes.dat")
    fun getAthletes(meetId: Long): Deferred<List<Athlete>>

    @GET("meets/{meetId}/events.dat")
    fun getEvents(meetId: Long): Deferred<Map<String, Event>>

    @GET("meets/{meetId}/eventsBySession.dat")
    fun getEventsBySession(meetId: Long): Deferred<EventsBySession>

    @GET("meets/{meetId}/eventsByStroke.dat")
    fun getEventsByStroke(meetId: Long): Deferred<EventsByStroke>

    @GET("meets/{meetId}/agegroups.dat")
    fun getAgegroups(meetId: Long): Deferred<Map<String, AgeGroup>>

    @GET("meets/{meetId}/results/{eventId}.dat")
    fun getResults(meetId: Long, eventId: Long): Deferred<Results>

    @GET("meets/{meetId}/heats/{eventId}.dat")
    fun getHeats(meetId: Long, eventId: Long): Deferred<Heats>

    @GET("meets/{meetId}/entries/{eventId}.dat")
    fun getEntries(meetId: Long, eventId: Long): Deferred<Entries>

    @GET("meets/{meetId}/athletes/{athleteId}.dat")
    fun getAthlete(meetId: Long, athleteId: Long): Deferred<AthleteDetails>

    @GET("meets/{meetId}/clubs/{clubId}.dat")
    fun getClub(meetId: Long, clubId: Long): Deferred<ClubResults>
}