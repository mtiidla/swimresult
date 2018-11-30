package ee.mtiidla.swimresult.ui.entrylist

import ee.mtiidla.swimresult.domain.model.Entry

sealed class EntryListData(val id: Long) {

    data class EntryItem(val entry: Entry) : EntryListData(entry.entrant.id)
}