package ee.mtiidla.swimresult.ui.athlete

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.EntrySummary
import ee.mtiidla.swimresult.domain.model.Event
import ee.mtiidla.swimresult.ui.event.EventDisplayer
import kotlinx.android.synthetic.main.view_entry_summary.view.*

class EntrySummaryView : ConstraintLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    private val eventDisplayer = EventDisplayer(resources)

    init {
        inflate(context, R.layout.view_entry_summary, this)
    }

    fun bindEntrySummary(entry: EntrySummary) {

        // TODO: Marko 19.12.2018 show date and time?
        entry.event!!.run {
            entrySummaryTitleView.text = eventDisplayer.getTitle(this)
            entrySummaryLabelView.setText(eventDisplayer.getRound(round))
            val label = if (round == Event.Round.FINAL) "Final" else "Heat"
            entrySummarySubtitleView.text = "$label ${entry.heatInfo.code}, Lane ${entry.lane}"
        }
        entrySummaryTimeView.text = entry.entryTime
    }
}