package ee.mtiidla.swimresult.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class ScreenFragment<T : Screen> : Fragment() {

    lateinit var screen: T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        screen = createScreen(container!!.context)
        return screen.getRootView()
    }

    abstract fun createScreen(context: Context): T
}