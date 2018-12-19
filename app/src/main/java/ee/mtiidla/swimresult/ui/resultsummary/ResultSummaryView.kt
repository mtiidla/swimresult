package ee.mtiidla.swimresult.ui.resultsummary

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.ClubAthlete
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
            resultSummarySubtitleView.text =
                if (place != -1) AgeGroupDisplayer.getTitle(ageGroup!!) else ""

            resultSummarySplitView.show(splits != null)
            splits.notNull {
                if (athletes == null) bindSplits(it) else bindClubSplits(athletes, it)
            }
        }
    }

    private fun bindSplits(splits: List<Split>) {
        val splitColumns =
            ResultDisplayer.getSplitColumns(splits, resultSummarySplitView.childCount)
        splitColumns.forEachIndexed { index, splitText ->
            getSplitView(index).text = splitText
        }
    }

    private fun bindClubSplits(athletes: List<ClubAthlete>, splits: List<Split>) {
        val splitColumns =
            ResultDisplayer.getSplitColumns(splits, resultSummarySplitView.childCount)
                .toMutableList()
        var names = ""
        var times = ""
        athletes.forEach {
            names += "${it.fullName}\n"
            times += "${it.swimTime}\n"
        }
        splitColumns[0] = names + "\n" + splitColumns[0]
        splitColumns[splitColumns.size - 1] = times + "\n" + splitColumns[splitColumns.size - 1]
        splitColumns.forEachIndexed { index, splitText ->
            getSplitView(index).text = splitText
        }
    }

    private fun getSplitView(index: Int) = resultSummarySplitView.getChildAt(index) as TextView
}
