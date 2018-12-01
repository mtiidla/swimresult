package ee.mtiidla.swimresult.ui.athlete

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ee.mtiidla.swimresult.di.Dependencies
import ee.mtiidla.swimresult.ui.DefaultViewModelFactory
import ee.mtiidla.swimresult.ui.ScreenFragment
import ee.mtiidla.swimresult.util.requireScreenArg
import javax.inject.Inject

class AthleteFragment : ScreenFragment<AthleteScreen>() {

    @Inject
    lateinit var viewModelFactory: DefaultViewModelFactory<AthleteViewModel>

    override fun createScreen(context: Context): AthleteScreen = AthleteScreen(context)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val screenArgs = requireScreenArg<AthleteScreenArgs>()

        Dependencies.appComponent.athlete()
            .athleteScreenArgs(screenArgs)
            .build()
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ViewModelProviders.of(this, viewModelFactory).get(AthleteViewModel::class.java)
            .screenState.observe(viewLifecycleOwner, Observer<AthleteState>(screen::render))
    }
}