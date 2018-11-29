package ee.mtiidla.swimresult.ui.clublist

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ee.mtiidla.swimresult.ui.DefaultViewModelFactory
import ee.mtiidla.swimresult.ui.ScreenFragment
import ee.mtiidla.swimresult.ui.meet.MeetFragment
import javax.inject.Inject

class ClubListFragment : ScreenFragment<ClubListScreen>() {

    @Inject
    lateinit var viewModelFactory: DefaultViewModelFactory<ClubListViewModel>

    override fun createScreen(context: Context): ClubListScreen = ClubListScreen(context)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (parentFragment as MeetFragment).meetComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ViewModelProviders.of(this, viewModelFactory).get(ClubListViewModel::class.java)
            .screenState.observe(viewLifecycleOwner, Observer<ClubListState>(screen::render))
    }
}