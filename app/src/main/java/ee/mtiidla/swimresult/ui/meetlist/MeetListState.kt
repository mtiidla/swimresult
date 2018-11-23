package ee.mtiidla.swimresult.ui.meetlist

import ee.mtiidla.swimresult.data.network.model.Meetgroup

sealed class MeetListState {

    object Loading : MeetListState()

    data class Data(val meetGroups : List<Meetgroup>) : MeetListState()

    data class Error(val error: Throwable) : MeetListState()

}