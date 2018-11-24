package ee.mtiidla.swimresult.ui.meet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ee.mtiidla.swimresult.data.repo.MeetRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider
import kotlin.coroutines.CoroutineContext

class MeetViewModel(private val meetRepository: MeetRepository, screenArgs: MeetScreenArgs) :
    ViewModel(),
    CoroutineScope {

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

class MeetViewModelFactory(
    private val meetRepository: Provider<MeetRepository>,
    private val meetScreenArgs: MeetScreenArgs
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MeetViewModel(meetRepository.get(), meetScreenArgs) as T
    }
}

class MeetViewModelArgumentFactory @Inject constructor(
    private val meetRepository: Provider<MeetRepository>
) {

    fun create(meetScreenArgs: MeetScreenArgs): MeetViewModelFactory {
        return MeetViewModelFactory(meetRepository, meetScreenArgs)
    }
}