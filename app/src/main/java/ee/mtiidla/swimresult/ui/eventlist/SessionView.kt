package ee.mtiidla.swimresult.ui.eventlist

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.Session
import ee.mtiidla.swimresult.util.show
import kotlinx.android.synthetic.main.view_session.view.*
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle

class SessionView : LinearLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    private val dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG, FormatStyle.SHORT)

    init {
        inflate(context, R.layout.view_session, this)
        orientation = VERTICAL
    }

    fun bindSession(session: Session) {
        val dateTime = dateTimeFormatter.format(
            if (session.time == null) session.date else session.date.atTime(session.time)
        )
        val showSessionName = session.name.isNotBlank()
        sessionSubtitleView.show(showSessionName)
        if (showSessionName) {
            sessionNameView.text = session.name
            sessionSubtitleView.text = dateTime
        } else {
            sessionNameView.text = dateTime
        }
    }
}