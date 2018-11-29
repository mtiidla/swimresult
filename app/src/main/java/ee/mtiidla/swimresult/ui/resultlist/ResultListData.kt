package ee.mtiidla.swimresult.ui.resultlist

import ee.mtiidla.swimresult.domain.model.AgeGroup
import ee.mtiidla.swimresult.domain.model.Result

sealed class ResultListData(val id: Long) {

    data class ResultItem(val result : Result) : ResultListData(result.athleteId)

    data class AgeGroupItem(val ageGroup: AgeGroup) : ResultListData(ageGroup.hashCode().toLong())

}