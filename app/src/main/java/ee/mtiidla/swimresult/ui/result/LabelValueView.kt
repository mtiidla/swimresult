package ee.mtiidla.swimresult.ui.result

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.annotation.StringRes
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.util.notNull
import kotlinx.android.synthetic.main.view_label_value.view.*

class LabelValueView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.view_label_value, this)

        attrs.notNull {

            val a = context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.LabelValueView,
                0, 0
            )

            try {
                labelView.text = a.getText(R.styleable.LabelValueView_lv_label)
                valueView.text = a.getText(R.styleable.LabelValueView_lv_value)
            } finally {
                a.recycle()
            }
        }
    }

    fun setLabel(@StringRes labelRes: Int) {
        labelView.setText(labelRes)
    }

    fun setLabel(label: CharSequence?) {
        labelView.text = label
    }

    fun setValue(value: CharSequence?) {
        valueView.text = value
    }
}