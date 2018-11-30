package ee.mtiidla.swimresult.ui

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ee.mtiidla.swimresult.util.putScreenArgs
import kotlin.reflect.KClass

abstract class ScreenFragment<T : Screen> : Fragment() {

    lateinit var screen: T

    abstract fun createScreen(context: Context): T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        screen = createScreen(container!!.context)
        return screen.getRootView()
    }

    companion object {

        // TODO: Marko 30.11.2018 enforce match of screen and screenargs via generic type?
        inline fun <F : Fragment, reified T : Parcelable> newInstance(
            fragmentClass: KClass<F>,
            screenArg: T
        ): F {
            return fragmentClass.java.newInstance().apply {
                arguments = Bundle().apply {
                    putScreenArgs(screenArg)
                }
            }
        }
    }
}