package ee.mtiidla.swimresult.ui.clublist

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.Club
import kotlinx.android.synthetic.main.view_club.view.*

class ClubView : FrameLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    init {
        inflate(context, R.layout.view_club, this)
    }

    fun bindClub(club: Club) {
        clubNameView.text = "${club.name} - ${club.code}"
    }
}
