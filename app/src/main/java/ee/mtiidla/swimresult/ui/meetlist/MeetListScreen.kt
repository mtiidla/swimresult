package ee.mtiidla.swimresult.ui.meetlist

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.Meet
import ee.mtiidla.swimresult.ui.Screen
import ee.mtiidla.swimresult.util.gone
import ee.mtiidla.swimresult.util.inflateLayout
import ee.mtiidla.swimresult.util.onTextChanged
import ee.mtiidla.swimresult.util.setStableIds
import ee.mtiidla.swimresult.util.visible
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.screen_meet_list.*

class MeetListScreen(context: Context) : Screen, LayoutContainer {

    override val containerView: ViewGroup = inflateLayout(context, R.layout.screen_meet_list)

    override fun getRootView(): ViewGroup = containerView

    lateinit var listener: Listener

    private val adapter: MeetListAdapter = MeetListAdapter { listener.onMeetClicked(it) }

    init {
        adapter.setStableIds()
        meetListView.layoutManager = LinearLayoutManager(context)
        meetListView.adapter = adapter
        meetSearchView.onTextChanged { listener.onMeetSearch(it) }
        meetSearchClearButton.setOnClickListener { meetSearchView.text = null }
    }

    fun render(state: MeetListState) {
        when (state) {
            is MeetListState.Loading -> {
                meetSearchView.isEnabled = false
                meetSearchClearButton.isEnabled = false
                progressBar.visible()
                meetListView.gone()
            }
            is MeetListState.Data -> {
                meetSearchView.isEnabled = true
                meetSearchClearButton.isEnabled = false
                meetListView.visible()
                progressBar.gone()

                val adapterData = mutableListOf<MeetListData>()
                state.meetGroups.forEach {
                    adapterData += MeetListData.MeetGroupItem(it)
                    adapterData += it.meets.map { meet -> MeetListData.MeetItem(meet) }
                }

                adapter.items = adapterData
            }
            is MeetListState.Search -> {
                meetSearchView.isEnabled = true
                meetSearchClearButton.isEnabled = true
                meetListView.visible()
                progressBar.gone()

                scrollToTopOnNextAdapterChange(meetListView)
                adapter.items = state.meets.map { MeetListData.MeetItem(it) }
            }
            is MeetListState.Error -> TODO()
        }
    }

    private fun scrollToTopOnNextAdapterChange(recylcerView: RecyclerView) {
        val adapter = recylcerView.adapter
        adapter?.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {

            override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                adapter.unregisterAdapterDataObserver(this)
                recylcerView.scrollToPosition(0)
            }

            override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
                adapter.unregisterAdapterDataObserver(this)
                recylcerView.scrollToPosition(0)
            }
        })
    }

    interface Listener {

        fun onMeetClicked(meet: Meet)

        fun onMeetSearch(query: String)
    }
}
