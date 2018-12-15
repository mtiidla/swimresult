package ee.mtiidla.swimresult.util

import android.app.Activity
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat

fun View.visible() {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
}

fun View.gone() {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }
}

fun View.show(show: Boolean = true) {
    if (show) {
        visible()
    } else {
        gone()
    }
}

fun View.string(@StringRes stringRes: Int): String = resources.getString(stringRes)

@ColorInt
fun View.color(@ColorRes colorRes: Int): Int = ContextCompat.getColor(context, colorRes)

fun inflateLayout(context: Context, @LayoutRes layoutRes: Int): ViewGroup {
    return LayoutInflater.from(context).inflate(layoutRes, null) as ViewGroup
}

/**
 * Inflates the view of type [V] from layoutRes
 * @throws ClassCastException when the layout's root view is not a type of [V]
 */
@Suppress("UNCHECKED_CAST")
fun <V : View> inflateView(parent: ViewGroup, @LayoutRes layoutRes: Int): V {
    return LayoutInflater.from(parent.context).inflate(layoutRes, parent, false) as V
}

fun EditText.onTextChanged(f: (String) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            f.invoke(s.toString())
        }
    })
}

fun EditText.hideKeyboard() {
    val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}