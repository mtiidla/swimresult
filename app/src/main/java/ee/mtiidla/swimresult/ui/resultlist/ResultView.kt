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
        resultPlaceBackgroundView.setBackgroundResource(getPlaceBackgroundRes(result.place))
        resultPlaceView.text = result.place.toString()
        resultLaneView.text = result.lane.toString()
        resultTimeView.text = result.swimTime
        resultEntryTimeView.text = result.entryTime

        resultSplitView.show(result.splits != null)
        result.splits.notNull { bindSplits(it) }

        resultDiffTimeView.show(result.place != 1)
        resultDiffTimeView.text = result.diff

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
        val columns = resultSplitView.childCount
        val splitColumns = Array(columns) { "" }
        val rowsInColumn = Math.ceil(splits.size / columns.toDouble()).toInt()

        // TODO: Marko 16.12.2018 club splits should show athletes as well?
        // TODO: Marko 16.12.2018 better align split times, padding by space is not enough
        splits.forEachIndexed { index, split ->
            splitColumns[index / rowsInColumn] += "\n${split.distanceText}: ${split.timeText}"
        }
        splitColumns.forEachIndexed { index, splitText ->
            (resultSplitView.getChildAt(index) as TextView).text = splitText.trimStart()
        }
    }

    private fun getPlaceBackgroundRes(place: Int) = when (place) {
        1 -> R.drawable.place_gold
        2 -> R.drawable.place_silver
        3 -> R.drawable.place_bronze
        else -> R.drawable.place_other
    }
}