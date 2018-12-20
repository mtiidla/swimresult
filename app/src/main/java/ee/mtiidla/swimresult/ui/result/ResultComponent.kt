package ee.mtiidla.swimresult.ui.result

import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent
interface ResultComponent {

    fun inject(fragment: ResultFragment)

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun resultScreenArgs(resultScreenArgs: ResultScreenArgs) : Builder

        fun build() : ResultComponent

    }

}
