package ee.mtiidla.swimresult.ui.resultlist

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.AgeGroup
import kotlinx.android.synthetic.main.view_age_group.view.*

class AgeGroupView : ConstraintLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    init {
        inflate(context, R.layout.view_age_group, this)
    }

    fun bindAgeGroup(ageGroup: AgeGroup) {
        ageGroupTitleView.text = ageGroup.toString()
    }
}