package ee.mtiidla.swimresult.ui.meet

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ee.mtiidla.swimresult.di.Dependencies
import ee.mtiidla.swimresult.ui.ScreenFragment
import ee.mtiidla.swimresult.util.requireParcelable
import javax.inject.Inject

class MeetFragment : ScreenFragment<MeetScreen>() {

    @Inject
    lateinit var viewModelFactory: MeetViewModelArgumentFactory

    override fun createScreen(context: Context) = MeetScreen(context)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Dependencies.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val screenArgs = requireParcelable<MeetScreenArgs>(SCREEN_ARG)

        ViewModelProviders.of(this, viewModelFactory.create(screenArgs))
            .get(MeetViewModel::class.java)
            .screenState.observe(viewLifecycleOwner, Observer<MeetState>(screen::render))
    }

    companion object {

        private val SCREEN_ARG = MeetScreenArgs::class.java.canonicalName

        fun newInstance(screenArg: MeetScreenArgs): MeetFragment {
            return MeetFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(SCREEN_ARG, screenArg)
                }
            }
        }
    }
}