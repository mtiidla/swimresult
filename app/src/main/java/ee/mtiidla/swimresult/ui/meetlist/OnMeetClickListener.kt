package ee.mtiidla.swimresult.ui.meetlist

import ee.mtiidla.swimresult.domain.model.Meet

interface OnMeetClickListener {

    fun onMeetClicked(meet: Meet)
}