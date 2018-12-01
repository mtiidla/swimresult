package ee.mtiidla.swimresult.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ee.mtiidla.swimresult.NavigationActivity
import ee.mtiidla.swimresult.SwimApplication
import ee.mtiidla.swimresult.ui.athlete.AthleteComponent
import ee.mtiidla.swimresult.ui.club.ClubComponent
import ee.mtiidla.swimresult.ui.event.EventComponent
import ee.mtiidla.swimresult.ui.meet.MeetComponent
import ee.mtiidla.swimresult.ui.meetlist.MeetListFragment

@ApplicationScope
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(application: SwimApplication)

    fun inject(navigationActivity: NavigationActivity)

    fun inject(meetListFragment: MeetListFragment)

    fun meet() : MeetComponent.Builder

    fun event() : EventComponent.Builder

    fun athlete() : AthleteComponent.Builder
    
    fun club() : ClubComponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(@ApplicationScope application: Application): Builder

        fun build(): AppComponent
    }
}