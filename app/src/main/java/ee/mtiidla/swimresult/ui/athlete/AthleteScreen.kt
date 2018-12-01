package ee.mtiidla.swimresult.ui.athlete

import android.content.Context
import android.view.ViewGroup
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.ui.Screen
import ee.mtiidla.swimresult.util.inflateLayout
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.screen_athlete.*

class AthleteScreen(context: Context) : Screen, LayoutContainer {

    override val containerView: ViewGroup = inflateLayout(context, R.layout.screen_athlete)

    override fun getRootView(): ViewGroup = containerView

    fun render(state: AthleteState) {
        when (state) {
            is AthleteState.Loading -> {
                athleteNameView.text = "Loading"
            }
            is AthleteState.Data -> {
                athleteNameView.text = state.athlete.toString()
            }
            is AthleteState.Error -> TODO()
        }
    }

}