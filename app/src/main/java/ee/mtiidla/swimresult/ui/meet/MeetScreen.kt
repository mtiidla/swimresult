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

    fun render(state: MeetState) {
        when (state) {
            is MeetState.Loading -> {

            }
            is MeetState.Data -> {
                meetNameView.text = state.meet.name
                meetCityView.text = state.meet.city
            }
        }
    }
}