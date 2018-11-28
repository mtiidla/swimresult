package ee.mtiidla.swimresult.ui.athletelist

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.ui.Screen
import ee.mtiidla.swimresult.util.gone
import ee.mtiidla.swimresult.util.inflateLayout
import ee.mtiidla.swimresult.util.setStableIds
import ee.mtiidla.swimresult.util.visible
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.screen_athlete_list.*
import timber.log.Timber

class AthleteListScreen(context: Context) : Screen, LayoutContainer {

    override val containerView: ViewGroup = inflateLayout(context, R.layout.screen_athlete_list)

    override fun getRootView(): ViewGroup = containerView

    private val adapter : AthleteListAdapter = AthleteListAdapter { Timber.d(it.toString())}

    init {
        adapter.setStableIds()
        athleteListView.adapter = adapter
        athleteListView.layoutManager = LinearLayoutManager(context)
    }

    fun render(state: AthleteListState) {
        when (state) {
            is AthleteListState.Loading -> {
                progressBar.visible()
                athleteListView.gone()
            }
            is AthleteListState.Data -> {
                progressBar.gone()
                athleteListView.visible()

                adapter.items = state.athletes.map { AthleteListData.AthleteItem(it) }
            }
            is AthleteListState.Error -> TODO("Implement")
        }
    }
}