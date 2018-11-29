package ee.mtiidla.swimresult.ui.resultlist

import ee.mtiidla.swimresult.domain.model.AgeGroupResults

sealed class ResultListState {

    data class Data(val results: List<AgeGroupResults>) : ResultListState()
}