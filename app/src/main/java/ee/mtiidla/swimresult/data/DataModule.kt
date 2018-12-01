package ee.mtiidla.swimresult.data

import com.squareup.moshi.Moshi
import dagger.Binds
import dagger.Module
import dagger.Provides
import ee.mtiidla.swimresult.data.network.NetworkModule
import ee.mtiidla.swimresult.data.network.adapter.AgeGroupsJsonMapAdapter
import ee.mtiidla.swimresult.data.network.adapter.EntryJsonParentAdapter
import ee.mtiidla.swimresult.data.network.adapter.EventsJsonMapAdapter
import ee.mtiidla.swimresult.data.network.adapter.ResultJsonParentAdapter
import ee.mtiidla.swimresult.data.network.service.CompetitorNetworkService
import ee.mtiidla.swimresult.data.network.service.EventNetworkService
import ee.mtiidla.swimresult.data.network.service.MeetNetworkService
import ee.mtiidla.swimresult.di.ApplicationScope
import ee.mtiidla.swimresult.domain.service.CompetitorService
import ee.mtiidla.swimresult.domain.service.EventService
import ee.mtiidla.swimresult.domain.service.MeetService

@Module(includes = [NetworkModule::class])
abstract class DataModule {

    @Binds
    abstract fun bindMeetService(meetService: MeetNetworkService): MeetService

    @Binds
    abstract fun bindEventService(EventService: EventNetworkService): EventService

    @Binds
    abstract fun bindAthleteService(competitorService: CompetitorNetworkService): CompetitorService

    @Module
    companion object {

        @Provides
        @ApplicationScope
        @JvmStatic
        fun provideMoshi(): Moshi {
            return Moshi.Builder()
                .add(EventsJsonMapAdapter())
                .add(AgeGroupsJsonMapAdapter())
                .add(EntryJsonParentAdapter())
                .add(ResultJsonParentAdapter())
                .build()
        }
    }
}
