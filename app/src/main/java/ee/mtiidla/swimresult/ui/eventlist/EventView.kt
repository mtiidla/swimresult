package ee.mtiidla.swimresult.ui.eventlist

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.Event
import ee.mtiidla.swimresult.ui.event.EventDisplayer
import ee.mtiidla.swimresult.util.color
import ee.mtiidla.swimresult.util.string
import kotlinx.android.synthetic.main.view_event.view.*
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle

class EventView : LinearLayout {

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    // TODO: Marko 15.12.2018 extract date and time formatters to some object
    private val timeFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)
    private val eventDisplayer = EventDisplayer(resources)

    init {
        inflate(context, R.layout.view_event, this)
        orientation = VERTICAL
    }

    fun bindEvent(event: Event) {
        event.run {
            eventNameView.text = eventDisplayer.getTitle(this)
            val round = string(eventDisplayer.getRound(round))
            eventSubtitleView.text = if (time == null) round else "${timeFormatter.format(time)} • $round"
            eventStatusView.setColorFilter(color(eventDisplayer.getStatusColorRes(status!!)))
        }
    }


}