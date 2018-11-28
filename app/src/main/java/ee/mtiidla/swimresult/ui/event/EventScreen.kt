package ee.mtiidla.swimresult.ui.event

import android.content.Context
import android.view.ViewGroup
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.ui.Screen
import ee.mtiidla.swimresult.ui.heat.HeatState
import ee.mtiidla.swimresult.ui.heatlist.HeatListScreen
import ee.mtiidla.swimresult.ui.heatlist.HeatListState
import ee.mtiidla.swimresult.util.inflateLayout
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.screen_event.*

class EventScreen(context: Context) : Screen, LayoutContainer {

    override val containerView: ViewGroup = inflateLayout(context, R.layout.screen_event)

    override fun getRootView(): ViewGroup = containerView

    private val heatListScreen = HeatListScreen(context)

    init {
        eventHeatsContainer.addView(heatListScreen.getRootView())
    }

    fun render(state: EventState) {
        when (state) {

            EventState.Loading -> {

            }
            is EventState.Data -> {
                eventNameView.text = state.event.toString()

                when (state) {
                    is EventState.Data.Empty -> {

                    }
                    is EventState.Data.Entries -> {

                    }
                    is EventState.Data.Heats -> {
                        heatListScreen.render(HeatListState.Data(state.heats.map { HeatState.Data(it) }))
                    }
                }
            }
            is EventState.Error -> TODO()
        }
    }
}