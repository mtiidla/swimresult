package ee.mtiidla.swimresult.ui.meetlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import ee.mtiidla.swimresult.data.repo.MeetRepository
import ee.mtiidla.swimresult.di.Dependencies
import ee.mtiidla.swimresult.ui.DefaultViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MeetListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: DefaultViewModelFactory<MeetListViewModel>

    private lateinit var viewModel: MeetListViewModel
    private lateinit var screen: MeetListScreen

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        screen = MeetListScreen(container!!.context)
        return screen.getRootView()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Dependencies.appComponent.inject(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MeetListViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.screenState.observe(viewLifecycleOwner, Observer<MeetListState>(screen::render))

    }

    class MeetListViewModel @Inject constructor(private val meetRepo: MeetRepository) :
        ViewModel(), CoroutineScope {

        override val coroutineContext: CoroutineContext = Dispatchers.Main

        private val viewState : MutableLiveData<MeetListState> = MutableLiveData()

        val screenState : LiveData<MeetListState> = viewState

        private var job: Job? = null

        init {

            job = launch {

                viewState.value = MeetListState.Loading
                val meets = meetRepo.meetGroups().await()

                viewState.value = MeetListState.Data(meets)

            }
        }

        override fun onCleared() {
            // TODO: Marko 23.11.2018 cancel here does not cancel network request
            job?.cancel()
        }

    }
}

