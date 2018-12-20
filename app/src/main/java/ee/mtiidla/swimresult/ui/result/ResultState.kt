package ee.mtiidla.swimresult.ui.result

import ee.mtiidla.swimresult.domain.model.Entry
import ee.mtiidla.swimresult.domain.model.Event
import ee.mtiidla.swimresult.domain.model.Heat
import ee.mtiidla.swimresult.domain.model.Result

sealed class ResultState {

    object Loading : ResultState()

    data class Data(
        val event: Event,
        val heat: Heat,
        val entry: Entry,
        val result: Result?
    ) : ResultState()

    data class Error(val error: Throwable) : ResultState()
}
