package ee.mtiidla.swimresult.ui.resultlist

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.AgeGroup
import kotlinx.android.synthetic.main.view_age_group.view.*

class AgeGroupView : FrameLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    init {
        inflate(context, R.layout.view_age_group, this)
    }

    fun bindAgeGroup(ageGroup: AgeGroup) {
        ageGroupTitleView.text = getDisplayableAgeGroup(ageGroup)
    }

    // TODO: Marko 16.12.2018 extract strategies
    private fun getDisplayableAgeGroup(ageGroup: AgeGroup): String = with(ageGroup) {
        ageGroup.name ?: when (ageGroup.key!![0]) {
            'a' -> {
                when (Character.getNumericValue(ageGroup.key[1])) {
                    1 -> {
                        "$min years"
                    }
                    2 -> {
                        "$max years and younger"
                    }
                    3 -> {
                        "$min years and older"
                    }
                    4 -> {
                        "$min - $max years"
                    }
                    else -> {
                        "Unknown age group"
                    }
                }
            }
            'y' -> {
                when (Character.getNumericValue(ageGroup.key[1])) {
                    1 -> {
                        "YOB $min"
                    }
                    2 -> {
                        "$max and younger"
                    }
                    3 -> {
                        "$min and older"
                    }
                    4 -> {
                        "YOB $min - $max"
                    }
                    else -> {
                        "Unknown age group"
                    }
                }
            }
            else -> {
                "Unknown age group"
            }
        }
    }
}