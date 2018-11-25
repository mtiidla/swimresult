package ee.mtiidla.swimresult.ui.meet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ee.mtiidla.swimresult.domain.repo.MeetRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MeetViewModel @Inject constructor(
    private val meetRepository: MeetRepository,
    screenArgs: MeetScreenArgs
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private val viewState = MutableLiveData<MeetState>()

    val screenState: LiveData<MeetState> = viewState

    init {

        launch {

            viewState.value = MeetState.Loading
            val meet = meetRepository.meet(screenArgs.meetId).await()
            viewState.value = MeetState.Data(meet)

        }
    }
}