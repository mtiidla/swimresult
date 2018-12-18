package ee.mtiidla.swimresult.ui.clublist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ee.mtiidla.swimresult.domain.repo.CompetitorRepository
import ee.mtiidla.swimresult.ui.UiScopedViewModel
import ee.mtiidla.swimresult.ui.meet.MeetScreenArgs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class ClubListViewModel @Inject constructor(
    private val competitorRepository: CompetitorRepository,
    screenArgs: MeetScreenArgs
) : UiScopedViewModel() {

    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private val viewState = MutableLiveData<ClubListState>()

    val screenState: LiveData<ClubListState> = viewState

    init {

        launch {

            viewState.value = ClubListState.Loading
            val clubs = withIO { competitorRepository.clubs(screenArgs.meetId) }
            viewState.value = ClubListState.Data(clubs.sortedBy { it.name })

        }
    }
}