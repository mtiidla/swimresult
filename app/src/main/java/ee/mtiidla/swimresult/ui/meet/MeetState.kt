package ee.mtiidla.swimresult.ui.meet

import ee.mtiidla.swimresult.domain.model.Meet

sealed class MeetState {

    object Loading : MeetState()

    data class Data(val meet: Meet) : MeetState()

    data class Error(val error: Throwable) : MeetState()
}