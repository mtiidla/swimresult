package ee.mtiidla.swimresult.ui.meet

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.di.Dependencies
import ee.mtiidla.swimresult.ui.DefaultViewModelFactory
import ee.mtiidla.swimresult.ui.ScreenFragment
import ee.mtiidla.swimresult.ui.athletelist.AthleteListFragment
import ee.mtiidla.swimresult.ui.eventlist.EventListFragment
import ee.mtiidla.swimresult.util.requireScreenArg
import kotlinx.android.synthetic.main.screen_meet.*
import javax.inject.Inject

class MeetFragment : ScreenFragment<MeetScreen>() {

    @Inject
    lateinit var viewModelFactory: DefaultViewModelFactory<MeetViewModel>

    lateinit var meetComponent: MeetComponent
        private set

    override fun createScreen(context: Context) = MeetScreen(context)

    override fun onCreate(savedInstanceState: Bundle?) {

        val screenArgs = requireScreenArg<MeetScreenArgs>()

        meetComponent = Dependencies.appComponent.meet()
            .meetScreenArgs(screenArgs)
            .build()

        meetComponent.inject(this)

        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ViewModelProviders.of(this, viewModelFactory).get(MeetViewModel::class.java)
            .screenState.observe(viewLifecycleOwner, Observer<MeetState>(screen::render))

        meetNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_events -> {
                    replaceChildFragment(EventListFragment())
                    true
                }
                R.id.menu_athletes -> {
                    replaceChildFragment(AthleteListFragment())
                    true
                }
                R.id.menu_clubs -> {
                    TODO()
                }
                else -> throw IllegalArgumentException("Unknown menu item $it")
            }
        }
        meetNavigationView.selectedItemId = R.id.menu_events
    }

    private fun replaceChildFragment(fragment: Fragment) {
        with(childFragmentManager.beginTransaction()) {
            replace(R.id.meetScreenContainer, fragment)
            commit()
        }
    }
}