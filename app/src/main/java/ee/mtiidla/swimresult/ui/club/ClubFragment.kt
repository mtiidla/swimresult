package ee.mtiidla.swimresult.ui.club

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

class ClubFragment : ScreenFragment<ClubScreen>() {

    @Inject
    lateinit var viewModelFactory: DefaultViewModelFactory<ClubViewModel>

    override fun createScreen(context: Context): ClubScreen = ClubScreen(context)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val screenArgs = requireScreenArg<ClubScreenArgs>()

        Dependencies.appComponent.club()
            .clubScreenArgs(screenArgs)
            .build()
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ViewModelProviders.of(this, viewModelFactory).get(ClubViewModel::class.java)
            .screenState.observe(viewLifecycleOwner, Observer<ClubState>(screen::render))
    }
}