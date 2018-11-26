package ee.mtiidla.swimresult.ui.athletelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ee.mtiidla.swimresult.domain.repo.AthleteRepository
import ee.mtiidla.swimresult.ui.meet.MeetScreenArgs
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class AthleteListViewModel @Inject constructor(
    private val athleteRepository: AthleteRepository,
    screenArgs: MeetScreenArgs
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private val viewState = MutableLiveData<AthleteListState>()

    val screenState: LiveData<AthleteListState> = viewState

    private var job: Job? = null

    init {

        job = launch {

            viewState.value = AthleteListState.Loading
            val athletes = athleteRepository.athletes(screenArgs.meetId).await()
            viewState.value = AthleteListState.Data(athletes.sortedBy { it.fullname })

        }
    }

    override fun onCleared() {
        job?.cancel()
    }

}