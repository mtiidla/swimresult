package ee.mtiidla.swimresult.ui.athlete

import ee.mtiidla.swimresult.domain.model.AthleteDetails

sealed class AthleteState {

    object Loading : AthleteState()

    data class Data(val athlete: AthleteDetails) : AthleteState()

    data class Error(val error: Throwable) : AthleteState()
}