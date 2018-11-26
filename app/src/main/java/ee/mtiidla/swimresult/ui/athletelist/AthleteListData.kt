package ee.mtiidla.swimresult.ui.athletelist

import ee.mtiidla.swimresult.domain.model.Athlete

sealed class AthleteListData(val id: Long) {

    data class AthleteItem(val athlete: Athlete) : AthleteListData(athlete.id)
}