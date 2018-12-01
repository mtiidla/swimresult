package ee.mtiidla.swimresult.ui.eventlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ee.mtiidla.swimresult.domain.repo.EventRepository
import ee.mtiidla.swimresult.ui.meet.MeetScreenArgs
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class EventListViewModel @Inject constructor(
    private val eventRepository: EventRepository,
    screenArgs: MeetScreenArgs
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private val viewState = MutableLiveData<EventListState>()

    val screenState: LiveData<EventListState> = viewState

    private var job: Job? = null

    init {

        job = launch {

            viewState.value = EventListState.Loading

            val events = eventRepository.events(screenArgs.meetId)
            val sessions = eventRepository.sessions(screenArgs.meetId)

            val eventBySession = sessions.await().associateWith { it.events }.mapValues { entry ->
                entry.value.map { sessionEvent ->
                    events.await().firstOrNull { sessionEvent.id == it.id }?.copy(status = sessionEvent.status)
                        ?: throw NullPointerException("Session event $sessionEvent not present in events: $events ")
                }
            }

            viewState.value = EventListState.Data(eventBySession)
        }
    }

    override fun onCleared() {
        job?.cancel()
    }
}
