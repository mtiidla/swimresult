package ee.mtiidla.swimresult.ui.resultlist

import androidx.annotation.DrawableRes
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.Split

object ResultDisplayer {

    @DrawableRes
    fun getPlaceBackgroundRes(place: Int) = when (place) {
        1 -> R.drawable.place_gold
        2 -> R.drawable.place_silver
        3 -> R.drawable.place_bronze
        else -> R.drawable.place_other
    }

    fun getSplitColumns(splits: List<Split>, numColumns: Int): List<String> {

        val splitColumns = Array(numColumns) { "" }
        val rowsInColumn = Math.ceil(splits.size / numColumns.toDouble()).toInt()

        // TODO: Marko 16.12.2018 club splits should show athletes as well?
        // TODO: Marko 16.12.2018 better align split times, padding by space is not enough
        splits.forEachIndexed { index, split ->
            splitColumns[index / rowsInColumn] += "\n${split.distanceText}: ${split.timeText}"
        }

        return splitColumns.map { it.trimStart() }
    }

}