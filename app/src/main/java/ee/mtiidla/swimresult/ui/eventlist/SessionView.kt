package ee.mtiidla.swimresult.ui.eventlist

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.Session
import kotlinx.android.synthetic.main.view_session.view.*
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle

class SessionView : ConstraintLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    private val dateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)

    init {
        inflate(context, R.layout.view_session, this)
    }

    fun bindSession(session: Session) {
        sessionNameView.text = "${session.number}. ${session.name}"
        sessionSubtitleView.text = "${session.course} ${session.date} ${session.time}, day: ${session.day}"
    }

}