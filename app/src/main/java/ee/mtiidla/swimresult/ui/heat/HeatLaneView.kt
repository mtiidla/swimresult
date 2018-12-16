package ee.mtiidla.swimresult.ui.heat

import android.content.Context
import android.util.AttributeSet
import ee.mtiidla.swimresult.domain.model.HeatLane
import ee.mtiidla.swimresult.ui.entrylist.EntryView
import ee.mtiidla.swimresult.util.whenNotNull
import kotlinx.android.synthetic.main.view_entry.view.*

class HeatLaneView : EntryView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    fun bindHeatLane(lane: HeatLane) {
        bindEntry(lane.entry)
        entryOrderView.text = whenNotNull(lane.entry.lane) { "$it." } ?: ""
    }
}