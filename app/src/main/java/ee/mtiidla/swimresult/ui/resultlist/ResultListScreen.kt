package ee.mtiidla.swimresult.ui.resultlist

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.Result
import ee.mtiidla.swimresult.ui.Screen
import ee.mtiidla.swimresult.util.inflateLayout
import ee.mtiidla.swimresult.util.setStableIds
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.screen_result_list.*

class ResultListScreen(context: Context) : Screen, LayoutContainer {

    override val containerView: ViewGroup = inflateLayout(context, R.layout.screen_result_list)

    override fun getRootView(): ViewGroup = containerView

    lateinit var listener: Listener

    private val adapter = ResultListAdapter { listener.onResultClicked(it) }

    init {
        adapter.setStableIds()
        resultListView.adapter = adapter
        resultListView.layoutManager = LinearLayoutManager(context)
    }

    fun render(state: ResultListState) {
        when (state) {
            is ResultListState.Data -> {
                val adapterData = mutableListOf<ResultListData>()
                state.results.forEach {
                    adapterData += ResultListData.AgeGroupItem(it.ageGroup!!)
                    adapterData += it.results.map { result -> ResultListData.ResultItem(result) }
                }

                adapter.items = adapterData
            }
        }
    }

    interface Listener {

        fun onResultClicked(result: Result)
    }
}