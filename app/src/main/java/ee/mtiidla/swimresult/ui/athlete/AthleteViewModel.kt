package ee.mtiidla.swimresult.ui.athlete

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

class AthleteViewModel @Inject constructor(
    private val eventRepository: EventRepository,
    private val meetRepository: MeetRepository,
    private val competitorRepository: CompetitorRepository,
    private val athleteScreenArgs: AthleteScreenArgs
) : UiScopedViewModel() {

    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private val viewState = MutableLiveData<AthleteState>()

    val screenState: LiveData<AthleteState> = viewState

    init {

        launch {
            val meetId = athleteScreenArgs.meetScreenArgs.meetId

            viewState.value = AthleteState.Loading
            val athleteDetails = asyncIO {
                competitorRepository.athlete(meetId, athleteScreenArgs.athleteId)
            }
            val events = asyncIO {
                eventRepository.events(meetId)
            }
            val ageGroups = asyncIO {
                meetRepository.ageGroups(meetId)
            }

            val ageGroupMap = ageGroups.await().associateBy { it.id }
            val eventMap = events.await().associateBy { it.id }
            val athlete = with(athleteDetails.await()) {
                copy(
                    entries = entries.map { it.copy(event = eventMap[it.eventId]) },
                    results = results.map {
                        it.copy(
                            event = eventMap[it.eventId],
                            ageGroup = ageGroupMap[it.ageGroupId]
                        )
                    })
            }

            viewState.value = AthleteState.Data(athlete)
        }
    }
}