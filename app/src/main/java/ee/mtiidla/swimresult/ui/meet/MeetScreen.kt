package ee.mtiidla.swimresult.ui.meet

import android.content.Context
import android.view.ViewGroup
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.ui.Screen
import ee.mtiidla.swimresult.util.inflateLayout
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.screen_meet.*

class MeetScreen(context: Context) : Screen, LayoutContainer {

    override val containerView: ViewGroup = inflateLayout(context, R.layout.screen_meet)

    override fun getRootView(): ViewGroup = containerView

    lateinit var listener: Listener

    init {
        toolbar.setNavigationOnClickListener { listener.onBackClicked() }
    }

    fun render(state: MeetState) {
        when (state) {
            is MeetState.Loading -> {
                // TODO: Marko 14.12.2018 implement
            }
            is MeetState.Data -> {
                meetCollapsingToolbar.title = state.meet.name
                meetCityView.text = state.meet.city
            }
        }
    }

    interface Listener {

        fun onBackClicked()
    }
}