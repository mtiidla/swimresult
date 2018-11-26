package ee.mtiidla.swimresult.ui.clublist

import ee.mtiidla.swimresult.domain.model.Club

sealed class ClubListState {

    object Loading : ClubListState()

    data class Data(val clubs: List<Club>) : ClubListState()

    data class Error(val error: Throwable) : ClubListState()
}