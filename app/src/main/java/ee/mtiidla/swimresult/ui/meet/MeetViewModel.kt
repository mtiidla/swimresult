package ee.mtiidla.swimresult.ui.meet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ee.mtiidla.swimresult.domain.repo.MeetRepository
import ee.mtiidla.swimresult.ui.UiScopedViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class MeetViewModel @Inject constructor(
    private val meetRepository: MeetRepository,
    screenArgs: MeetScreenArgs
) : UiScopedViewModel() {

    private val viewState = MutableLiveData<MeetState>()

    val screenState: LiveData<MeetState> = viewState

    init {

        launch {

            viewState.value = MeetState.Loading
            val meet = withIO {
                meetRepository.meet(screenArgs.meetId)
            }
            viewState.value = MeetState.Data(meet)

        }
    }
}