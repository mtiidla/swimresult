package ee.mtiidla.swimresult.ui.club

import android.content.Context
import android.view.ViewGroup
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.ui.Screen
import ee.mtiidla.swimresult.util.inflateLayout
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.screen_club.*

class ClubScreen(context: Context) : Screen, LayoutContainer {

    override val containerView: ViewGroup = inflateLayout(context, R.layout.screen_club)

    override fun getRootView(): ViewGroup = containerView

    fun render(state: ClubState) {
        when (state) {
            is ClubState.Loading -> {
                clubNameView.text = "Loading"
            }
            is ClubState.Data -> {
                clubNameView.text = state.club.toString()
            }
            is ClubState.Error -> TODO()
        }
    }

}