package ee.mtiidla.swimresult.ui.meetlist

import ee.mtiidla.swimresult.domain.model.Meet
import ee.mtiidla.swimresult.domain.model.MeetGroup

sealed class MeetListData(val id: Long) {

    data class MeetGroupItem(val meetGroup: MeetGroup) : MeetListData(meetGroup.country.hashCode().toLong())

    data class MeetItem(val meet: Meet) : MeetListData(meet.id)
}