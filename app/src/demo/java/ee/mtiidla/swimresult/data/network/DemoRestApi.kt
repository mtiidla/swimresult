package ee.mtiidla.swimresult.data.network

import com.squareup.moshi.Moshi
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import okio.Okio
import javax.inject.Inject

class DemoRestApi @Inject constructor(
    val moshi: Moshi,
    private val fileDataSource: FileDataSource
) :
    RestApi {

    override fun getMeets(): Deferred<Meets> = getData("meets.json")

    override fun getMeet(meetId: Long): Deferred<MeetDetail> = getData("meet.json")

    override fun getClubs(meetId: Long): Deferred<List<Club>> = getData("clubs.json")

    override fun getAthletes(meetId: Long): Deferred<List<Athlete>> = getData("athletes.json")

    override fun getEvents(meetId: Long): Deferred<Map<String, Event>> = getData("events.json")

    override fun getEventsBySession(meetId: Long): Deferred<EventsBySession> =
        getData("eventsBySession.json")

    override fun getEventsByStroke(meetId: Long): Deferred<EventsByStroke> =
        getData("eventsByStroke.json")

    override fun getAgegroups(meetId: Long): Deferred<Map<String, AgeGroup>> =
        getData("agegroups.json")

    override fun getResults(meetId: Long, eventId: Long): Deferred<Results> =
        getData("results.json")

    override fun getHeats(meetId: Long, eventId: Long): Deferred<Heats> = getData("heats.json")

    override fun getEntries(meetId: Long, eventId: Long): Deferred<Entries> =
        getData("entries.json")

    override fun getAthlete(meetId: Long, athleteId: Long): Deferred<AthleteDetails> =
        getData("athlete.json")

    override fun getClub(meetId: Long, clubId: Long): Deferred<ClubResults> = getData("club.json")

    private inline fun <reified T> getData(fileName: String): Deferred<T> {
        return CoroutineScope(Dispatchers.IO).async {
            moshi.adapter(T::class.java).fromJson(
                Okio.buffer(Okio.source(fileDataSource.getFileStream(fileName)))
            ) ?: throw NullPointerException("Data from file [$fileName] data source was null")
        }
    }
}
