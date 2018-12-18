package ee.mtiidla.swimresult.ui.club

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ee.mtiidla.swimresult.domain.repo.CompetitorRepository
import ee.mtiidla.swimresult.ui.UiScopedViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class ClubViewModel @Inject constructor(
    private val competitorRepository: CompetitorRepository,
    private val clubScreenArgs: ClubScreenArgs
) : UiScopedViewModel() {

    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private val viewState = MutableLiveData<ClubState>()

    val screenState: LiveData<ClubState> = viewState

    init {

        launch {
            viewState.value = ClubState.Loading
            val club = withIO {
                competitorRepository.club(
                    clubScreenArgs.meetScreenArgs.meetId,
                    clubScreenArgs.clubId
                )
            }
            viewState.value = ClubState.Data(club)
        }
    }
}