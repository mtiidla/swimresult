package ee.mtiidla.swimresult.ui.club

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.ui.Screen
import ee.mtiidla.swimresult.ui.club.adapter.ClubAdapter
import ee.mtiidla.swimresult.util.gone
import ee.mtiidla.swimresult.util.inflateLayout
import ee.mtiidla.swimresult.util.setStableIds
import ee.mtiidla.swimresult.util.visible
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.screen_club.*

class ClubScreen(context: Context) : Screen, LayoutContainer {

    override val containerView: ViewGroup = inflateLayout(context, R.layout.screen_club)

    override fun getRootView(): ViewGroup = containerView
    
    private val adapter = ClubAdapter()

    init {
        adapter.setStableIds()
        clubDetailsListView.adapter = adapter
        clubDetailsListView.layoutManager = LinearLayoutManager(context)
    }
    
    fun render(state: ClubState) {
        when (state) {
            is ClubState.Loading -> {
                progressBar.visible()
                clubDetailsListView.gone()
            }
            is ClubState.Data -> {
                progressBar.gone()
                clubDetailsListView.visible()

                val adapterData = mutableListOf<ClubAdapterData>()
                adapterData += ClubAdapterData.ClubItem(state.club)

                if (state.club.results.isNotEmpty()) {
                    adapterData += ClubAdapterData.ResultHeaderItem
                    state.club.results.forEach {
                        adapterData += ClubAdapterData.ResultItem(it)
                    }
                }
                if (state.club.entries.isNotEmpty()) {
                    adapterData += ClubAdapterData.EntryHeaderItem
                    state.club.entries.forEach {
                        adapterData += ClubAdapterData.EntryItem(it)
                    }
                }
                adapter.items = adapterData
            }
            is ClubState.Error -> TODO()
        }
    }

}