package ee.mtiidla.swimresult.ui.meet

import dagger.BindsInstance
import dagger.Subcomponent
import ee.mtiidla.swimresult.ui.athletelist.AthleteListFragment
import ee.mtiidla.swimresult.ui.clublist.ClubListFragment
import ee.mtiidla.swimresult.ui.eventlist.EventListFragment

@Subcomponent
interface MeetComponent {

    fun inject(meetFragment: MeetFragment)

    fun inject(eventListFragment: EventListFragment)

    fun inject(athleteListFragment: AthleteListFragment)

    fun inject(clubListFragment: ClubListFragment)

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun meetScreenArgs(meetScreenArgs: MeetScreenArgs) : Builder

        fun build() : MeetComponent

    }


}