package ee.mtiidla.swimresult.ui.event

import ee.mtiidla.swimresult.domain.model.Entry
import ee.mtiidla.swimresult.domain.model.Event
import ee.mtiidla.swimresult.domain.model.Heat

sealed class EventState {

    object Loading : EventState()

    sealed class Data : EventState() {

        abstract val event: Event

        data class Empty(override val event: Event) : Data()

        data class Entries(override val event: Event, val entries: List<Entry>) : Data()

        data class Heats(override val event: Event, val heats: List<Heat>) : Data()

    }

    data class Error(val error: Throwable) : EventState()
}
