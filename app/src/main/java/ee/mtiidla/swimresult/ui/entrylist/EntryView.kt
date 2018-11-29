package ee.mtiidla.swimresult.ui.entrylist

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.Entry
import kotlinx.android.synthetic.main.view_entry.view.*

class EntryView : ConstraintLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    init {
        inflate(context, R.layout.view_entry, this)
    }

    fun bindEntry(entry : Entry) {
        entryTitleView.text = entry.toString()
    }
}