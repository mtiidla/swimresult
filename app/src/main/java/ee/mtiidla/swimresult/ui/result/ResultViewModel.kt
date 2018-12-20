package ee.mtiidla.swimresult.ui.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ee.mtiidla.swimresult.domain.repo.EventRepository
import ee.mtiidla.swimresult.ui.UiScopedViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class ResultViewModel @Inject constructor(
    private val eventRepository: EventRepository,
    private val resultScreenArgs: ResultScreenArgs
) : UiScopedViewModel() {

    private val viewState = MutableLiveData<ResultState>()

    val screenState: LiveData<ResultState> = viewState

    init {
        launch {
            viewState.value = ResultState.Loading

            val result = asyncIO {
                eventRepository.results(
                    resultScreenArgs.eventScreenArgs.meetScreenArgs.meetId,
                    resultScreenArgs.eventScreenArgs.eventId
                ).flatMap { it.results }.firstOrNull { it.competitor.id == resultScreenArgs.competitorId }
            }
            val event = asyncIO {
                eventRepository.events(resultScreenArgs.eventScreenArgs.meetScreenArgs.meetId)
                    .first { it.id == resultScreenArgs.eventScreenArgs.eventId }
            }
            // TODO: Marko 20.12.2018 heat is not available when not seeded?
            val heat = asyncIO {
                eventRepository.heats(
                    resultScreenArgs.eventScreenArgs.meetScreenArgs.meetId,
                    resultScreenArgs.eventScreenArgs.eventId
                ).first { heat -> heat.entries.any { entry -> entry.competitor.id == resultScreenArgs.competitorId }}
            }.await()

            val entry = heat.entries.first { it.competitor.id == resultScreenArgs.competitorId  }

            viewState.value = ResultState.Data(event.await(), heat, entry, result.await())
        }
    }
}
