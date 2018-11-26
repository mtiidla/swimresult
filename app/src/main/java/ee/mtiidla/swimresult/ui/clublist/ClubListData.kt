package ee.mtiidla.swimresult.ui.clublist

import ee.mtiidla.swimresult.domain.model.Club

sealed class ClubListData(val id: Long) {

    data class ClubItem(val club: Club) : ClubListData(club.id)
}