package ee.mtiidla.swimresult.ui.athletelist

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.Athlete
import kotlinx.android.synthetic.main.view_athlete.view.*

class AthleteView : FrameLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    init {
        inflate(context, R.layout.view_athlete, this)
    }

    fun bindAthlete(athlete: Athlete) {
        athleteNameView.text = athlete.fullname
    }
}
