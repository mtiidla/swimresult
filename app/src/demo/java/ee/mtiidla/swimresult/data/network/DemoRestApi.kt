package ee.mtiidla.swimresult.data.network

import com.squareup.moshi.Moshi
import ee.mtiidla.swimresult.data.network.model.AgeGroupsNetworkModel
import ee.mtiidla.swimresult.data.network.model.AthleteDetailsNetworkModel
import ee.mtiidla.swimresult.data.network.model.AthleteNetworkModel
import ee.mtiidla.swimresult.data.network.model.ClubNetworkModel
import ee.mtiidla.swimresult.data.network.model.ClubDetailsNetworkModel
import ee.mtiidla.swimresult.data.network.model.EntriesNetworkModel
import ee.mtiidla.swimresult.data.network.model.EventsByStroke
import ee.mtiidla.swimresult.data.network.model.EventsNetworkModel
import ee.mtiidla.swimresult.data.network.model.HeatsNetworkModel
import ee.mtiidla.swimresult.data.network.model.MeetNetworkModel
import ee.mtiidla.swimresult.data.network.model.MeetsNetworkModel
import ee.mtiidla.swimresult.data.network.model.ResultsNetworkModel
import ee.mtiidla.swimresult.data.network.model.SessionsNetworkModel
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

    override fun getMeets(): Deferred<MeetsNetworkModel> = getData("meets.json")

    override fun getMeet(meetId: Long): Deferred<MeetNetworkModel> = getData("meet.json")

    override fun getClubs(meetId: Long): Deferred<List<ClubNetworkModel>> = getData("clubs.json")

    override fun getAthletes(meetId: Long): Deferred<List<AthleteNetworkModel>> = getData("athletes.json")

    override fun getEvents(meetId: Long): Deferred<EventsNetworkModel> = getData("events.json")

    override fun getEventsBySession(meetId: Long): Deferred<SessionsNetworkModel> =
        getData("eventsBySession.json")

    override fun getEventsByStroke(meetId: Long): Deferred<EventsByStroke> =
        getData("eventsByStroke.json")

    override fun getAgegroups(meetId: Long): Deferred<AgeGroupsNetworkModel> =
        getData("agegroups.json")

    override fun getResults(meetId: Long, eventId: Long): Deferred<ResultsNetworkModel> =
        getData("results.json")

    override fun getHeats(meetId: Long, eventId: Long): Deferred<HeatsNetworkModel> = getData("heats.json")

    override fun getEntries(meetId: Long, eventId: Long): Deferred<EntriesNetworkModel> =
        getData("entries.json")

    override fun getAthlete(meetId: Long, athleteId: Long): Deferred<AthleteDetailsNetworkModel> =
        getData("athlete.json")

    override fun getClub(meetId: Long, clubId: Long): Deferred<ClubDetailsNetworkModel> = getData("club.json")

    private inline fun <reified T> getData(fileName: String): Deferred<T> {
        return CoroutineScope(Dispatchers.IO).async {
            moshi.adapter(T::class.java).fromJson(
                Okio.buffer(Okio.source(fileDataSource.getFileStream(fileName)))
            ) ?: throw NullPointerException("Data from file [$fileName] data source was null")
        }
    }
}
