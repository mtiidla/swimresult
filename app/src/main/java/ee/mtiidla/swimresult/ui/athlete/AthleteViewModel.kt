package ee.mtiidla.swimresult.ui.athlete

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ee.mtiidla.swimresult.domain.repo.CompetitorRepository
import ee.mtiidla.swimresult.ui.UiScopedViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class AthleteViewModel @Inject constructor(
    private val competitorRepository: CompetitorRepository,
    private val athleteScreenArgs: AthleteScreenArgs
) : UiScopedViewModel() {

    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private val viewState = MutableLiveData<AthleteState>()

    val screenState: LiveData<AthleteState> = viewState

    init {

        launch {
            viewState.value = AthleteState.Loading
            val athlete = withIO {
                competitorRepository.athlete(
                    athleteScreenArgs.meetScreenArgs.meetId,
                    athleteScreenArgs.athleteId
                )
            }
            viewState.value = AthleteState.Data(athlete)
        }
    }
}