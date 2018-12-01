package ee.mtiidla.swimresult.ui.club

import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent
interface ClubComponent {

    fun inject(clubFragment: ClubFragment)

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun clubScreenArgs(clubScreenArgs: ClubScreenArgs) : Builder

        fun build(): ClubComponent
    }
}