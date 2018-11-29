package ee.mtiidla.swimresult.ui.entrylist

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.ui.Screen
import ee.mtiidla.swimresult.util.inflateLayout
import ee.mtiidla.swimresult.util.setStableIds
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.screen_entry_list.*

class EntryListScreen(context: Context) : Screen, LayoutContainer {

    override val containerView: ViewGroup = inflateLayout(context, R.layout.screen_entry_list)

    override fun getRootView(): ViewGroup = containerView

    private val adapter = EntryAdapter()

    init {
        adapter.setStableIds()
        entryListView.adapter = adapter
        entryListView.layoutManager = LinearLayoutManager(context)
    }

    fun render(state: EntryListState) {
        when (state) {
            is EntryListState.Data -> {
                adapter.items = state.entries.map { EntryListData.EntryItem(it) }
            }
        }
    }
}