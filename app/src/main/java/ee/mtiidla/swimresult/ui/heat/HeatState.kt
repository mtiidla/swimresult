package ee.mtiidla.swimresult.ui.heat

import ee.mtiidla.swimresult.domain.model.Heat

sealed class HeatState {

    data class Data(val heat: Heat) : HeatState()
}