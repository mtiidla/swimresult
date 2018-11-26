package ee.mtiidla.swimresult.ui.athletelist

import ee.mtiidla.swimresult.domain.model.Athlete

sealed class AthleteListState {

    object Loading : AthleteListState()

    data class Data(val athletes: List<Athlete>) : AthleteListState()

    data class Error(val error: Throwable) : AthleteListState()
}