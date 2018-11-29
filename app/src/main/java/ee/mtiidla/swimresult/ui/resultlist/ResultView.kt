package ee.mtiidla.swimresult.ui.resultlist

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.Result
import kotlinx.android.synthetic.main.view_result.view.*

class ResultView : ConstraintLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    init {
        inflate(context, R.layout.view_result, this)
    }

    fun bindResult(result: Result) {
        resultTitleView.text = result.toString()
    }
}