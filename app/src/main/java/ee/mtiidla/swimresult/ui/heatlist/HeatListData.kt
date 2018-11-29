package ee.mtiidla.swimresult.ui.heatlist

import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.ui.entrylist.EntryListState
import ee.mtiidla.swimresult.ui.heat.HeatState

sealed class HeatListData(val id: Long) {

    data class HeatItem(val heatState: HeatState) :
        HeatListData(heatState.hashCode().toLong()) // TODO: Marko 27.11.2018 id

    data class EntryListItem(val entryListState: EntryListState) :
        HeatListData(-R.id.list_item_entry_list.toLong())
}