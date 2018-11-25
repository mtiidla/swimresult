package ee.mtiidla.swimresult.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

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