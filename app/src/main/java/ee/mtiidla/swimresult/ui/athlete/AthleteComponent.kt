package ee.mtiidla.swimresult.ui.athlete

import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent
interface AthleteComponent {

    fun inject(athleteFragment: AthleteFragment)

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun athleteScreenArgs(athleteScreenArgs: AthleteScreenArgs) : Builder

        fun build(): AthleteComponent
    }
}