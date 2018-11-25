package ee.mtiidla.swimresult.ui.meetlist

import ee.mtiidla.swimresult.domain.model.Meet

sealed class MeetListData(val id: Long) {

    data class MeetGroupItem(val title: String) : MeetListData(title.hashCode().toLong())

    data class MeetItem(val meet: Meet) : MeetListData(meet.id)
}