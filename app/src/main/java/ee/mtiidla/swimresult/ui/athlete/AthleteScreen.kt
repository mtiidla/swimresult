package ee.mtiidla.swimresult.ui.athlete

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.ui.Screen
import ee.mtiidla.swimresult.ui.athlete.adapter.AthleteAdapter
import ee.mtiidla.swimresult.util.gone
import ee.mtiidla.swimresult.util.inflateLayout
import ee.mtiidla.swimresult.util.setStableIds
import ee.mtiidla.swimresult.util.visible
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.screen_athlete.*

class AthleteScreen(context: Context) : Screen, LayoutContainer {

    override val containerView: ViewGroup = inflateLayout(context, R.layout.screen_athlete)

    override fun getRootView(): ViewGroup = containerView

    private val adapter = AthleteAdapter()

    init {
        adapter.setStableIds()
        athleteDetailsListView.adapter = adapter
        athleteDetailsListView.layoutManager = LinearLayoutManager(context)
    }

    fun render(state: AthleteState) {
        when (state) {
            is AthleteState.Loading -> {
                progressBar.visible()
                athleteDetailsListView.gone()
            }
            is AthleteState.Data -> {
                progressBar.gone()
                athleteDetailsListView.visible()

                val adapterData = mutableListOf<AthleteData>()
                adapterData += AthleteData.AthleteItem(state.athlete)
                adapterData += AthleteData.ResultHeaderItem
                state.athlete.results.forEach {
                    adapterData += AthleteData.ResultItem(it)
                }
                adapterData += AthleteData.EntryHeaderItem
                state.athlete.entries.forEach {
                    adapterData += AthleteData.EntryItem(it)
                }
                adapter.items = adapterData
            }
            is AthleteState.Error -> TODO()
        }
    }

}