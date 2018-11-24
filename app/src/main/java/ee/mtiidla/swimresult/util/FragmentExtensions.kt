package ee.mtiidla.swimresult.util

import android.os.Parcelable
import androidx.fragment.app.Fragment

fun Fragment.requireArgs() = this.arguments!!

fun <T : Parcelable> Fragment.requireParcelable(key: String): T {
    return requireArgs().getParcelable(key)!!
}