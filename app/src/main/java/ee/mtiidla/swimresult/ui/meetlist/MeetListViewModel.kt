package ee.mtiidla.swimresult.ui.meetlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ee.mtiidla.swimresult.domain.model.Meet
import ee.mtiidla.swimresult.domain.model.MeetGroup
import ee.mtiidla.swimresult.domain.repo.MeetRepository
import ee.mtiidla.swimresult.ui.UiScopedViewModel
import ee.mtiidla.swimresult.util.notNull
import kotlinx.coroutines.launch
import javax.inject.Inject

class MeetListViewModel @Inject constructor(private val meetRepo: MeetRepository) :
    UiScopedViewModel() {

    private val viewState: MutableLiveData<MeetListState> = MutableLiveData()

    val screenState: LiveData<MeetListState> = viewState

    private var meetGroups: List<MeetGroup>? = null
    private var meets: List<Meet>? = null

    init {

        launch {

            viewState.value = MeetListState.Loading
            val meets = withIO { meetRepo.meetGroups() }
            meetGroups = meets
            viewState.value = MeetListState.Data(meets)

        }
    }

    fun onMeetFilter(query: String) {
        meetGroups.notNull {
            if (query.isNotBlank()) {
                if (meets == null) {
                    meets = it.flatMap { meetGroup -> meetGroup.meets }
                }
                meets.notNull { meets ->
                    val filteredMeets = mutableSetOf<Meet>()
                    meets.filterTo(filteredMeets) { meet -> meet.name.startsWith(query, true) }
                    meets.filterTo(filteredMeets) { meet ->
                        meet.name.contains(query, true)
                            || meet.city.contains(query, true)
                    }
                    viewState.value = MeetListState.Filter(filteredMeets.toList())
                }
            } else {
                viewState.value = MeetListState.Data(it)
            }
        }
    }
}