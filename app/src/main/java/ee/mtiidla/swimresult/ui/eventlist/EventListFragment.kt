package ee.mtiidla.swimresult.ui.eventlist

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ee.mtiidla.swimresult.NavigationActivity
import ee.mtiidla.swimresult.domain.model.Event
import ee.mtiidla.swimresult.ui.DefaultViewModelFactory
import ee.mtiidla.swimresult.ui.ScreenFragment
import ee.mtiidla.swimresult.ui.event.EventFragment
import ee.mtiidla.swimresult.ui.event.EventScreenArgs
import ee.mtiidla.swimresult.ui.meet.MeetFragment
import ee.mtiidla.swimresult.ui.meet.MeetScreenArgs
import javax.inject.Inject

class EventListFragment : ScreenFragment<EventListScreen>() {

    @Inject
    lateinit var viewModelFactory: DefaultViewModelFactory<EventListViewModel>

    @Inject
    lateinit var meetScreenArgs: MeetScreenArgs

    override fun createScreen(context: Context): EventListScreen = EventListScreen(context)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (parentFragment as MeetFragment).meetComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        screen().listener = object : EventListScreen.Listener {
            override fun onEventClicked(event: Event) {
                openEventScreen(event)
            }
        }

        ViewModelProviders.of(this, viewModelFactory).get(EventListViewModel::class.java)
            .screenState.observe(viewLifecycleOwner, Observer<EventListState>(screen()::render))
    }

    private fun openEventScreen(event: Event) {
        (activity as NavigationActivity).replaceFragment(
            newInstance(EventFragment::class, EventScreenArgs(meetScreenArgs, event.id)), true
        )
    }
}