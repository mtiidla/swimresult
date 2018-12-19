package ee.mtiidla.swimresult.ui.resultlist

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.Competitor
import ee.mtiidla.swimresult.domain.model.Result
import ee.mtiidla.swimresult.domain.model.Split
import ee.mtiidla.swimresult.util.CountryFlagImageLoader
import ee.mtiidla.swimresult.util.notNull
import ee.mtiidla.swimresult.util.show
import kotlinx.android.synthetic.main.view_result.view.*

class ResultView : ConstraintLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    init {
        inflate(context, R.layout.view_result, this)
    }

    fun bindResult(result: Result) {
        // TODO: Marko 16.12.2018 handle DSQ etc
        result.run {
            resultPlaceBackgroundView.setBackgroundResource(ResultDisplayer.getPlaceBackgroundRes(place))
            resultPlaceView.text = place.toString()
            resultLaneView.text = lane.toString()
            resultTimeView.text = swimTime
            resultEntryTimeView.text = entryTime

            resultSplitView.show(splits != null)
            splits.notNull { bindSplits(it) }

            resultDiffTimeView.show(place != 1)
            resultDiffTimeView.text = diff
        }

        result.competitor.run {
            when (this) {
                is Competitor.Club -> {
                    resultLabelView.text = clubCode
                    resultTitleView.text = clubName
                    resultSubtitleView.text = nation
                }
                is Competitor.Athlete -> {
                    resultLabelView.text = firstName
                    resultTitleView.text = lastName
                    resultSubtitleView.text = clubName
                }
            }
            CountryFlagImageLoader.loadFlag(nation, resultNationFlagView)
        }
    }

    private fun bindSplits(splits: List<Split>) {
        val splitColumns = ResultDisplayer.getSplitColumns(splits, resultSplitView.childCount)
        splitColumns.forEachIndexed { index, splitText ->
            (resultSplitView.getChildAt(index) as TextView).text = splitText
        }
    }
}