package ee.mtiidla.swimresult.ui.athletelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ee.mtiidla.swimresult.domain.repo.CompetitorRepository
import ee.mtiidla.swimresult.ui.UiScopedViewModel
import ee.mtiidla.swimresult.ui.meet.MeetScreenArgs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class AthleteListViewModel @Inject constructor(
    private val competitorRepository: CompetitorRepository,
    screenArgs: MeetScreenArgs
) : UiScopedViewModel() {

    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private val viewState = MutableLiveData<AthleteListState>()

    val screenState: LiveData<AthleteListState> = viewState

    init {

        launch {

            viewState.value = AthleteListState.Loading
            val athletes = withIO { competitorRepository.athletes(screenArgs.meetId) }
            viewState.value = AthleteListState.Data(athletes.sortedBy { it.fullname })

        }
    }
}