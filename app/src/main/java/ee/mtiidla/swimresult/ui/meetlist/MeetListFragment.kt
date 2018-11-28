package ee.mtiidla.swimresult.ui.meetlist

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ee.mtiidla.swimresult.NavigationActivity
import ee.mtiidla.swimresult.di.Dependencies
import ee.mtiidla.swimresult.domain.model.Meet
import ee.mtiidla.swimresult.ui.DefaultViewModelFactory
import ee.mtiidla.swimresult.ui.ScreenFragment
import ee.mtiidla.swimresult.ui.meet.MeetFragment
import ee.mtiidla.swimresult.ui.meet.MeetScreenArgs
import ee.mtiidla.swimresult.ui.meetlist.MeetListScreen.Listener
import javax.inject.Inject

class MeetListFragment : ScreenFragment<MeetListScreen>() {

    @Inject
    lateinit var viewModelFactory: DefaultViewModelFactory<MeetListViewModel>

    private lateinit var viewModel: MeetListViewModel

    override fun createScreen(context: Context) = MeetListScreen(context)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Dependencies.appComponent.inject(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MeetListViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        screen.listener = object : Listener {
            override fun onMeetClicked(meet: Meet) {
                openMeetScreen(meet)
            }
        }

        viewModel.screenState.observe(viewLifecycleOwner, Observer<MeetListState>(screen::render))
    }

    private fun openMeetScreen(meet: Meet) {
        (activity as NavigationActivity).replaceFragment(
            newInstance(MeetFragment::class, MeetScreenArgs(meet.id)), true
        )
    }
}

