package ee.mtiidla.swimresult.ui.event

import android.content.Context
import android.view.ViewGroup
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.ui.Screen
import ee.mtiidla.swimresult.ui.eventinfo.EventInfoScreen
import ee.mtiidla.swimresult.ui.eventinfo.EventInfoState
import ee.mtiidla.swimresult.util.inflateLayout
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.screen_event.*

class EventScreen(context: Context) : Screen, LayoutContainer {

    override val containerView: ViewGroup = inflateLayout(context, R.layout.screen_event)

    override fun getRootView(): ViewGroup = containerView

    private val infoScreen = EventInfoScreen(context)

    init {
        eventHeatsContainer.addView(infoScreen.getRootView())
    }

    fun render(state: EventState) {
        when (state) {

            EventState.Loading -> {

            }
            is EventState.Data -> {
                eventNameView.text = state.eventInfo.event.toString()
                infoScreen.render(EventInfoState.Data(state.eventInfo))
            }
            is EventState.Error -> TODO()
        }
    }
}