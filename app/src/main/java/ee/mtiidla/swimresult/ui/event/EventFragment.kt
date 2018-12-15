package ee.mtiidla.swimresult.ui.event

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

class EventFragment : ScreenFragment<EventScreen>() {

    override fun createScreen(context: Context): EventScreen = EventScreen(context)

    @Inject
    lateinit var viewModelFactory: DefaultViewModelFactory<EventViewModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val screenArgs = requireScreenArg<EventScreenArgs>()

        Dependencies.appComponent.event()
            .eventScreenArgs(screenArgs)
            .build()
            .inject(this)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        screen().listener = object : EventScreen.Listener {
            override fun onBackClicked() {
                requireActivity().supportFragmentManager.popBackStack()
            }
        }

        ViewModelProviders.of(this, viewModelFactory).get(EventViewModel::class.java)
            .screenState.observe(viewLifecycleOwner, Observer<EventState>(screen()::render))

    }

}