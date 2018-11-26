package ee.mtiidla.swimresult.ui.clublist

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.ui.Screen
import ee.mtiidla.swimresult.util.gone
import ee.mtiidla.swimresult.util.inflateLayout
import ee.mtiidla.swimresult.util.visible
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.screen_club_list.*
import timber.log.Timber

class ClubListScreen(context: Context) : Screen, LayoutContainer {

    override val containerView: ViewGroup = inflateLayout(context, R.layout.screen_club_list)

    override fun getRootView(): ViewGroup = containerView

    private val adapter : ClubListAdapter = ClubListAdapter { Timber.d(it.toString())}

    init {
        adapter.setHasStableIds(true)
        clubListView.adapter = adapter
        clubListView.layoutManager = LinearLayoutManager(context)
    }

    fun render(state: ClubListState) {
        when (state) {
            is ClubListState.Loading -> {
                progressBar.visible()
                clubListView.gone()
            }
            is ClubListState.Data -> {
                progressBar.gone()
                clubListView.visible()

                adapter.items = state.clubs.map { ClubListData.ClubItem(it) }
            }
            is ClubListState.Error -> TODO("Implement")
        }
    }
}