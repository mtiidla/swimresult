package ee.mtiidla.swimresult.ui.clublist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ee.mtiidla.swimresult.domain.repo.CompetitorRepository
import ee.mtiidla.swimresult.ui.meet.MeetScreenArgs
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class ClubListViewModel @Inject constructor(
    private val competitorRepository: CompetitorRepository,
    screenArgs: MeetScreenArgs
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private val viewState = MutableLiveData<ClubListState>()

    val screenState: LiveData<ClubListState> = viewState

    private var job: Job? = null

    init {

        job = launch {

            viewState.value = ClubListState.Loading
            val clubs = competitorRepository.clubs(screenArgs.meetId).await()
            viewState.value = ClubListState.Data(clubs.sortedBy { it.name })

        }
    }

    override fun onCleared() {
        job?.cancel()
    }

}