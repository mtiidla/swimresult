package ee.mtiidla.swimresult.ui.athletelist

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ee.mtiidla.swimresult.ui.DefaultViewModelFactory
import ee.mtiidla.swimresult.ui.ScreenFragment
import ee.mtiidla.swimresult.ui.meet.MeetFragment
import javax.inject.Inject

class AthleteListFragment : ScreenFragment<AthleteListScreen>() {

    @Inject
    lateinit var viewModelFactory: DefaultViewModelFactory<AthleteListViewModel>

    override fun createScreen(context: Context): AthleteListScreen = AthleteListScreen(context)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (parentFragment as MeetFragment).meetComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ViewModelProviders.of(this, viewModelFactory).get(AthleteListViewModel::class.java)
            .screenState.observe(viewLifecycleOwner, Observer<AthleteListState>(screen::render))
    }
}