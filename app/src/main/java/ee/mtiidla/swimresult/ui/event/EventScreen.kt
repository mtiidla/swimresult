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

class EventScreen(private val context: Context) : Screen, LayoutContainer {

    override val containerView: ViewGroup = inflateLayout(context, R.layout.screen_event)

    override fun getRootView(): ViewGroup = containerView

    lateinit var listener: Listener

    private val infoScreen = EventInfoScreen(context)

    private val eventDisplayer = EventDisplayer(context.resources)

    init {
        eventInfoContainer.addView(infoScreen.getRootView())
        toolbar.setNavigationOnClickListener { listener.onBackClicked() }
    }

    fun render(state: EventState) {
        when (state) {

            EventState.Loading -> {

            }
            is EventState.Data -> {
                state.eventInfo.event.run {
                    // TODO: Marko 16.12.2018 show meet name, animate event title to toolbar
                    eventTitleView.text = eventDisplayer.getTitle(this)
                    eventSubtitleView.text = context.getString(eventDisplayer.getRound(round))
                }
                infoScreen.render(EventInfoState.Data(state.eventInfo))
            }
            is EventState.Error -> TODO()
        }
    }

    interface Listener {

        fun onBackClicked()
    }
}