package ee.mtiidla.swimresult.ui.athlete

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.ResultSummary
import ee.mtiidla.swimresult.domain.model.Split
import ee.mtiidla.swimresult.ui.event.EventDisplayer
import ee.mtiidla.swimresult.ui.resultlist.AgeGroupDisplayer
import ee.mtiidla.swimresult.ui.resultlist.ResultDisplayer
import ee.mtiidla.swimresult.ui.resultlist.ResultDisplayer.getPlaceBackgroundRes
import ee.mtiidla.swimresult.util.notNull
import ee.mtiidla.swimresult.util.show
import kotlinx.android.synthetic.main.view_result_summary.view.*

class ResultSummaryView : ConstraintLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    private val eventDisplayer = EventDisplayer(resources)

    init {
        inflate(context, R.layout.view_result_summary, this)
    }

    fun bindResultSummary(result: ResultSummary) {
        result.event!!.run {
            resultSummaryTitleView.text = eventDisplayer.getTitle(this)
            resultSummaryLabelView.setText(eventDisplayer.getRound(round))
        }

        result.run {
            resultSummaryPlaceBackgroundView.setBackgroundResource(getPlaceBackgroundRes(place))
            resultSummaryPlaceView.text = place.toString()
            resultSummaryTimeView.text = swimTime
            resultSummaryEntryTimeView.text = entryTime
            resultSummarySubtitleView.text = AgeGroupDisplayer.getTitle(ageGroup!!)

            resultSummarySplitView.show(splits != null)
            splits.notNull { bindSplits(it) }
        }


    }

    private fun bindSplits(splits: List<Split>) {
        val splitColumns = ResultDisplayer.getSplitColumns(splits, resultSummarySplitView.childCount)
        splitColumns.forEachIndexed { index, splitText ->
            (resultSummarySplitView.getChildAt(index) as TextView).text = splitText
        }
    }
}
