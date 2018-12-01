package ee.mtiidla.swimresult.ui.club

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

class ClubViewModel @Inject constructor(
    private val competitorRepository: CompetitorRepository,
    private val clubScreenArgs: ClubScreenArgs
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private val viewState = MutableLiveData<ClubState>()

    val screenState: LiveData<ClubState> = viewState

    private var job: Job? = null

    init {

        job = launch {
            viewState.value = ClubState.Loading
            val club = competitorRepository.club(
                clubScreenArgs.meetScreenArgs.meetId,
                clubScreenArgs.clubId
            ).await()
            viewState.value = ClubState.Data(club)
        }
    }

    override fun onCleared() {
        job?.cancel()
    }
}