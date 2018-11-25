package ee.mtiidla.swimresult.ui.meetlist

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.Meet
import ee.mtiidla.swimresult.ui.Screen
import ee.mtiidla.swimresult.util.gone
import ee.mtiidla.swimresult.util.inflateLayout
import ee.mtiidla.swimresult.util.notNull
import ee.mtiidla.swimresult.util.visible
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.screen_meet_list.*

class MeetListScreen(context: Context) : Screen, LayoutContainer {

    override val containerView: ViewGroup = inflateLayout(context, R.layout.screen_meet_list)

    override fun getRootView(): ViewGroup = containerView

    private val adapter: MeetListAdapter = MeetListAdapter { meet ->
        listener.notNull { it.onMeetClicked(meet) }
    }

    var listener: Listener? = null

    init {
        adapter.setHasStableIds(true)
        meetListView.layoutManager = LinearLayoutManager(context)
        meetListView.adapter = adapter
    }

    fun render(state: MeetListState) {
        when (state) {
            // TODO: Marko 24.11.2018 handle error state
            is MeetListState.Loading -> {
                progressBar.visible()
                meetListView.gone()
            }
            is MeetListState.Data -> {
                meetListView.visible()
                progressBar.gone()

                val adapterData = mutableListOf<MeetListData>()
                state.meetGroups.forEach {
                    adapterData += MeetListData.MeetGroupItem("${it.country.code} - ${it.country.name}")
                    adapterData += it.meets.map { meet -> MeetListData.MeetItem(meet) }
                }

                adapter.items = adapterData
            }
        }
    }

    interface Listener {

        fun onMeetClicked(meet: Meet)
    }
}
