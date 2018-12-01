package ee.mtiidla.swimresult.ui.athlete

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ee.mtiidla.swimresult.domain.repo.CompetitorRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class AthleteViewModel @Inject constructor(
    private val competitorRepository: CompetitorRepository,
    private val athleteScreenArgs: AthleteScreenArgs
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private val viewState = MutableLiveData<AthleteState>()

    val screenState: LiveData<AthleteState> = viewState

    private var job: Job? = null

    init {

        job = launch {
            viewState.value = AthleteState.Loading
            val athlete = competitorRepository.athlete(
                athleteScreenArgs.meetScreenArgs.meetId,
                athleteScreenArgs.athleteId
            ).await()
            viewState.value = AthleteState.Data(athlete)
        }
    }

    override fun onCleared() {
        job?.cancel()
    }
}