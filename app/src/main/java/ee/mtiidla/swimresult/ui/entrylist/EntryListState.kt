package ee.mtiidla.swimresult.ui.entrylist

import ee.mtiidla.swimresult.domain.model.Entry

sealed class EntryListState {

    data class Data(val entries: List<Entry>) : EntryListState()
}