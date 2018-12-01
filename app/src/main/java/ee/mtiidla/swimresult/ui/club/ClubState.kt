package ee.mtiidla.swimresult.ui.club

import ee.mtiidla.swimresult.domain.model.ClubDetails

sealed class ClubState {

    object Loading : ClubState()

    data class Data(val club: ClubDetails) : ClubState()

    data class Error(val error: Throwable) : ClubState()
}