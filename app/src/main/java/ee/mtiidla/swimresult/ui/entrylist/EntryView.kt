package ee.mtiidla.swimresult.ui.entrylist

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.Competitor
import ee.mtiidla.swimresult.domain.model.Entry
import ee.mtiidla.swimresult.util.CountryFlagImageLoader
import ee.mtiidla.swimresult.util.whenNotNull
import kotlinx.android.synthetic.main.view_entry.view.*

open class EntryView : ConstraintLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    init {
        inflate(context, R.layout.view_entry, this)
    }

    fun bindEntry(entry: Entry) {
        // TODO: Marko 16.12.2018 handle -1 place
        entryOrderView.text = whenNotNull(entry.place) { if (it == -1) "DNS" else "$it." } ?: ""
        entryTimeView.text = entry.entryTime
        entry.competitor.run {
            when (this) {
                is Competitor.Club -> {
                    entryLabelView.text = clubCode
                    entryTitleView.text = clubName
                    entrySubtitleView.text = nation
                }
                is Competitor.Athlete -> {
                    entryLabelView.text = firstName
                    entryTitleView.text = lastName
                    entrySubtitleView.text = clubName
                }
            }
            CountryFlagImageLoader.loadFlag(nation, entryNationFlagView)
        }
    }
}