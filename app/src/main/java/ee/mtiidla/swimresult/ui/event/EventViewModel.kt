package ee.mtiidla.swimresult.ui.event

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ee.mtiidla.swimresult.domain.model.EventInfo
import ee.mtiidla.swimresult.domain.repo.EventRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class EventViewModel @Inject constructor(
    private val eventRepository: EventRepository,
    private val screenArgs: EventScreenArgs
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private val viewState = MutableLiveData<EventState>()

    val screenState: LiveData<EventState> = viewState

    private var job: Job? = null

    init {
        job = launch {

            val meetId = screenArgs.meetScreenArgs.meetId
            val eventId = screenArgs.eventId

            viewState.value = EventState.Loading
            val event =
                eventRepository.events(meetId).await().firstOrNull { it.id == eventId }
                    ?: throw NullPointerException("Event not found $eventId")

            val entries = eventRepository.entries(meetId, eventId).await()
            val heats = eventRepository.heats(meetId, eventId).await()

            viewState.value = EventState.Data(EventInfo(event, entries, heats))

        }
    }
}