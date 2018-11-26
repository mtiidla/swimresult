package ee.mtiidla.swimresult.data

import dagger.Binds
import dagger.Module
import ee.mtiidla.swimresult.data.network.NetworkModule
import ee.mtiidla.swimresult.data.network.service.AthleteNetworkService
import ee.mtiidla.swimresult.data.network.service.EventNetworkService
import ee.mtiidla.swimresult.data.network.service.MeetNetworkService
import ee.mtiidla.swimresult.domain.service.AthleteService
import ee.mtiidla.swimresult.domain.service.EventService
import ee.mtiidla.swimresult.domain.service.MeetService

@Module(includes = [NetworkModule::class])
abstract class DataModule {

    @Binds
    abstract fun bindMeetService(meetService: MeetNetworkService): MeetService

    @Binds
    abstract fun bindEventService(EventService: EventNetworkService): EventService

    @Binds
    abstract fun bindAthleteService(AthleteService: AthleteNetworkService): AthleteService
}
