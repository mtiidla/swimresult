package ee.mtiidla.swimresult.ui.event

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ee.mtiidla.swimresult.NavigationActivity
import ee.mtiidla.swimresult.di.Dependencies
import ee.mtiidla.swimresult.domain.model.Result
import ee.mtiidla.swimresult.ui.DefaultViewModelFactory
import ee.mtiidla.swimresult.ui.ScreenFragment
import ee.mtiidla.swimresult.ui.result.ResultFragment
import ee.mtiidla.swimresult.ui.result.ResultScreenArgs
import ee.mtiidla.swimresult.util.requireScreenArg
import javax.inject.Inject

class EventFragment : ScreenFragment<EventScreen>() {

    override fun createScreen(context: Context): EventScreen = EventScreen(context)

    @Inject
    lateinit var viewModelFactory: DefaultViewModelFactory<EventViewModel>

    lateinit var screenArgs: EventScreenArgs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        screenArgs = requireScreenArg()

        Dependencies.appComponent.event()
            .eventScreenArgs(screenArgs)
            .build()
            .inject(this)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        screen().setListener(object : EventScreen.Listener {
            override fun onResultClicked(result: Result) {
                openResultScreen(result)
            }

            override fun onBackClicked() {
                requireActivity().supportFragmentManager.popBackStack()
            }
        })

        ViewModelProviders.of(this, viewModelFactory).get(EventViewModel::class.java)
            .screenState.observe(viewLifecycleOwner, Observer<EventState>(screen()::render))

    }

    private fun openResultScreen(result: Result) {
        (activity as NavigationActivity).replaceFragment(
            newInstance(ResultFragment::class, ResultScreenArgs(screenArgs, result.competitor.id)), true
        )
    }

}