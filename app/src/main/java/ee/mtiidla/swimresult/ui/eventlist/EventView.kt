package ee.mtiidla.swimresult.ui.eventlist

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.Event
import kotlinx.android.synthetic.main.view_event.view.*

class EventView : ConstraintLayout {

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    init {
        inflate(context, R.layout.view_event, this)
    }

    fun bindEvent(event: Event) {
        eventNameView.text = "${event.number}. ${event.gender}, ${event.distance}, ${event.stroke}"
        eventSubtitleView.text = "status: ${event.status} round: ${event.round} ${event.date} ${event.time}, is relay: ${event.relay}"
    }

}