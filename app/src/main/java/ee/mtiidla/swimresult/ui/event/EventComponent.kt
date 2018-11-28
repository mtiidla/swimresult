package ee.mtiidla.swimresult.ui.event

import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent
interface EventComponent {

    fun inject(eventFragment: EventFragment)

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun eventScreenArgs(eventScreenArgs: EventScreenArgs) : Builder

        fun build() : EventComponent

    }


}