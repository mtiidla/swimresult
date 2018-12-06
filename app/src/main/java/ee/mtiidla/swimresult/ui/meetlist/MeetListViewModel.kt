package ee.mtiidla.swimresult.ui.meetlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ee.mtiidla.swimresult.domain.model.Meet
import ee.mtiidla.swimresult.domain.model.MeetGroup
import ee.mtiidla.swimresult.domain.repo.MeetRepository
import ee.mtiidla.swimresult.util.notNull
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
    private var meetGroups: List<MeetGroup>? = null
    private var meets: List<Meet>? = null

    init {

        job = launch {

            viewState.value = MeetListState.Loading
            val meets = meetRepo.meetGroups().await()
            meetGroups = meets
            viewState.value = MeetListState.Data(meets)

        }
    }

    fun onMeetSearch(query: String) {
        meetGroups.notNull {
            if (query.isNotBlank()) {
                if (meets == null) {
                    meets = it.flatMap { meetGroup -> meetGroup.meets }
                }
                meets.notNull { meets ->
                    val filteredMeets = mutableSetOf<Meet>()
                    meets.filterTo(filteredMeets) { meet -> meet.name.startsWith(query, true) }
                    meets.filterTo(filteredMeets) { meet -> meet.name.contains(query, true) }
                    viewState.value = MeetListState.Search(filteredMeets.toList())
                }
            } else {
                viewState.value = MeetListState.Data(it)
            }
        }
    }

    override fun onCleared() {
        // TODO: Marko 23.11.2018 cancel here does not cancel network request, just delivery
        job?.cancel()
    }
}