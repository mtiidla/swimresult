package ee.mtiidla.swimresult.ui.meetlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ee.mtiidla.swimresult.domain.repo.MeetRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MeetListViewModel @Inject constructor(private val meetRepo: MeetRepository) :
    ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private val viewState: MutableLiveData<MeetListState> = MutableLiveData()

    val screenState: LiveData<MeetListState> = viewState

    private var job: Job? = null

    init {

        job = launch {

            viewState.value = MeetListState.Loading
            val meets = meetRepo.meetGroups().await()

            viewState.value = MeetListState.Data(meets)

        }
    }

    override fun onCleared() {
        // TODO: Marko 23.11.2018 cancel here does not cancel network request, just delivery
        job?.cancel()
    }
}