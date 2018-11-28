package ee.mtiidla.swimresult.ui.heat

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.HeatLane
import kotlinx.android.synthetic.main.view_heat_lane.view.*

class HeatLaneView : ConstraintLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    init {
        inflate(context, R.layout.view_heat_lane, this)
    }

    fun bindHeatLane(lane: HeatLane) {
        heatLaneTitleView.text = lane.blob
    }
}