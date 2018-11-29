package ee.mtiidla.swimresult.ui.eventinfo

import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.ui.entrylist.EntryListState
import ee.mtiidla.swimresult.ui.heat.HeatState
import ee.mtiidla.swimresult.ui.resultlist.ResultListState

sealed class EventInfoData(val id: Long) {

    data class HeatItem(val heatState: HeatState) :
        EventInfoData(heatState.hashCode().toLong()) // TODO: Marko 27.11.2018 id

    data class EntryListItem(val entryListState: EntryListState) :
        EventInfoData(-R.id.list_item_entry_list.toLong())

    data class ResultListItem(val resultListState: ResultListState) :
        EventInfoData(-R.id.list_item_result_list.toLong())
}