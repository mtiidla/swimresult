package ee.mtiidla.swimresult.ui.event

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ee.mtiidla.swimresult.domain.model.EventInfo
import ee.mtiidla.swimresult.domain.repo.EventRepository
import ee.mtiidla.swimresult.domain.repo.MeetRepository
import ee.mtiidla.swimresult.ui.UiScopedViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class EventViewModel @Inject constructor(
    private val eventRepository: EventRepository,
    private val meetRepository: MeetRepository,
    private val screenArgs: EventScreenArgs
) : UiScopedViewModel() {

    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private val viewState = MutableLiveData<EventState>()

    val screenState: LiveData<EventState> = viewState

    init {
        launch {

            val meetId = screenArgs.meetScreenArgs.meetId
            val eventId = screenArgs.eventId

            viewState.value = EventState.Loading

            val event = asyncIO { eventRepository.events(meetId) }
            val ageGroups = asyncIO {  meetRepository.ageGroups(meetId) }
            val entries = asyncIO {  eventRepository.entries(meetId, eventId) }
            val heats = asyncIO {  eventRepository.heats(meetId, eventId) }
            val results = asyncIO {  eventRepository.results(meetId, eventId) }

            val ageGroupResults =
                results.await().map { it.copy(ageGroup = ageGroups.await().firstOrNull { ageGroup -> it.id == ageGroup.id }) }

            viewState.value = EventState.Data(EventInfo(event.await().firstOrNull { it.id == eventId }
                ?: throw NullPointerException("Event not found $eventId"), entries.await(), heats.await(), ageGroupResults))

        }
    }
}