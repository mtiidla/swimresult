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

class EntryView : ConstraintLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    init {
        inflate(context, R.layout.view_entry, this)
    }

    fun bindEntry(entry: Entry) {
        // TODO: Marko 15.12.2018 maybe use single line for firstname and lastname, find a way to get lastname properly
        entryOrderView.text = whenNotNull(entry.place) { "$it." } ?: ""
        entryTimeView.text = entry.entryTime
        entry.competitor.run {
            when (this) {
                is Competitor.Club -> {
                    entryLabelView.text = clubCode
                    entryTitleView.text = clubName
                    entrySubtitleView.text = nation
                }
                is Competitor.Athlete -> {
                    val names = athleteName.split(" ")
                    val lastName = names.last()
                    entryLabelView.text = athleteName.subSequence(0, athleteName.length - lastName.length - 1)
                    entryTitleView.text = lastName
                    entrySubtitleView.text = clubName
                }
            }
            CountryFlagImageLoader.loadFlag(nation, entryNationFlagView)
        }
    }
}