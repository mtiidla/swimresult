package ee.mtiidla.swimresult.ui.meetlist

import ee.mtiidla.swimresult.domain.model.Meet

sealed class MeetListData {

    data class MeetGroupItem(val title: String) : MeetListData()

    data class MeetItem(val meet: Meet) : MeetListData()
}