package ee.mtiidla.swimresult.ui.club

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ee.mtiidla.swimresult.domain.repo.CompetitorRepository
import ee.mtiidla.swimresult.domain.repo.EventRepository
import ee.mtiidla.swimresult.domain.repo.MeetRepository
import ee.mtiidla.swimresult.ui.UiScopedViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class ClubViewModel @Inject constructor(
    private val eventRepository: EventRepository,
    private val meetRepository: MeetRepository,
    private val competitorRepository: CompetitorRepository,
    private val clubScreenArgs: ClubScreenArgs
) : UiScopedViewModel() {

    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private val viewState = MutableLiveData<ClubState>()

    val screenState: LiveData<ClubState> = viewState

    init {

        launch {
            val meetId = clubScreenArgs.meetScreenArgs.meetId

            viewState.value = ClubState.Loading
            val clubDetails = asyncIO {
                competitorRepository.club(meetId, clubScreenArgs.clubId)
            }
            val events = asyncIO {
                eventRepository.events(meetId)
            }
            val ageGroups = asyncIO {
                meetRepository.ageGroups(meetId)
            }

            val ageGroupMap = ageGroups.await().associateBy { it.id }
            val eventMap = events.await().associateBy { it.id }
            val club = with(clubDetails.await()) {
                copy(
                    entries = entries.map { it.copy(event = eventMap[it.eventId]) },
                    results = results.map {
                        it.copy(
                            event = eventMap[it.eventId],
                            ageGroup = ageGroupMap[it.ageGroupId]
                        )
                    })
            }

            viewState.value = ClubState.Data(club)
        }
    }
}