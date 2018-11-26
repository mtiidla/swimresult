package ee.mtiidla.swimresult.util

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment

fun Fragment.requireArgs() = this.arguments!!

// TODO: Marko 25.11.2018 verify that when proguarded, the reified is used correctly
inline fun <reified T : Parcelable> Fragment.requireScreenArg(): T {
    return requireArgs().getParcelable(T::class.java.canonicalName)!!
}

inline fun <reified T : Parcelable> Bundle.putScreenArgs(screenArgs: T) {
    putParcelable(T::class.java.canonicalName, screenArgs)
}