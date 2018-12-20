package ee.mtiidla.swimresult.ui.result

import android.content.Context
import android.view.ViewGroup
import android.widget.LinearLayout.LayoutParams
import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.Event
import ee.mtiidla.swimresult.domain.model.Split
import ee.mtiidla.swimresult.ui.Screen
import ee.mtiidla.swimresult.ui.event.EventDisplayer
import ee.mtiidla.swimresult.util.inflateLayout
import ee.mtiidla.swimresult.util.notNull
import ee.mtiidla.swimresult.util.setPaddingRes
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.screen_result.*

class ResultScreen(context: Context) : Screen, LayoutContainer {

    override val containerView: ViewGroup = inflateLayout(context, R.layout.screen_result)

    override fun getRootView(): ViewGroup = containerView

    private val eventDisplayer = EventDisplayer(context.resources)

    init {

    }

    fun render(state: ResultState) {
        when (state) {
            is ResultState.Loading -> {
                // TODO: Marko 20.12.2018 show loading
            }
            is ResultState.Data -> {
                resultCompetitorView.text = state.entry.competitor.displayName
                state.entry.run {
                    resultEventView.setValue(eventDisplayer.getTitle(state.event))
                    val label = if (state.event.round == Event.Round.FINAL) "Final" else "Heat"
                    resultHeatLaneView.setValue("$label ${state.heat.code}, Lane $lane")
                }
                state.result?.run {

                    resultEntryTimeView.setValue(entryTime)
                    resultInfoView.setValue(info)

                    resultPlaceView.setValue(place.toString())
                    resultTimeView.setValue(swimTime)
                    resultDiffTimeView.setValue(diff)

                    resultSplitView.removeAllViews()
                    splits.notNull { renderSplits(it) }
                }
            }
            is ResultState.Error -> TODO("Implement")
        }
    }

    private fun renderSplits(splits: List<Split>) {
        splits.forEach {
            val splitView = LabelValueView(resultSplitView.context)
            splitView.setLabel(it.distanceText)
            splitView.setValue(it.timeText)
            splitView.setPaddingRes(R.dimen.spacing_8)
            resultSplitView.addView(
                splitView,
                LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            )

        }
    }
}