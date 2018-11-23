package ee.mtiidla.swimresult.util

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import kotlinx.android.extensions.LayoutContainer

fun LayoutContainer.inflateLayout(context: Context, @LayoutRes layoutRes: Int): ViewGroup {
    return LayoutInflater.from(context).inflate(layoutRes, null) as ViewGroup
}