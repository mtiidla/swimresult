package ee.mtiidla.swimresult.ui.meetlist

import ee.mtiidla.swimresult.domain.model.Meet
import ee.mtiidla.swimresult.domain.model.MeetGroup

sealed class MeetListState {

    object Loading : MeetListState()

    data class Data(val meetGroups: List<MeetGroup>) : MeetListState()

    data class Search(val meets: List<Meet>) : MeetListState()

    data class Error(val error: Throwable) : MeetListState()
}