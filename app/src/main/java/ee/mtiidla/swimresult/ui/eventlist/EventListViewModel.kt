package ee.mtiidla.swimresult.ui.eventlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ee.mtiidla.swimresult.domain.repo.EventRepository
import ee.mtiidla.swimresult.ui.UiScopedViewModel
import ee.mtiidla.swimresult.ui.meet.MeetScreenArgs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class EventListViewModel @Inject constructor(
    private val eventRepository: EventRepository,
    screenArgs: MeetScreenArgs
) : UiScopedViewModel() {

    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private val viewState = MutableLiveData<EventListState>()

    val screenState: LiveData<EventListState> = viewState

    init {

        launch {

            viewState.value = EventListState.Loading

            val events = asyncIO { eventRepository.suspendedEvents(screenArgs.meetId) }
            val sessions = asyncIO { eventRepository.sessions(screenArgs.meetId) }

            val eventBySession = sessions.await().associateWith { it.events }.mapValues { entry ->
                entry.value.map { sessionEvent ->
                    events.await().firstOrNull { sessionEvent.id == it.id }?.copy(status = sessionEvent.status)
                        ?: throw NullPointerException("Session event $sessionEvent not present in events: $events ")
                }
            }

            viewState.value = EventListState.Data(eventBySession)
        }
    }
}
