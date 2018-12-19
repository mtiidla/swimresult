package ee.mtiidla.swimresult.ui.club

import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.ClubDetails
import ee.mtiidla.swimresult.domain.model.EntrySummary
import ee.mtiidla.swimresult.domain.model.ResultSummary

sealed class ClubAdapterData(val id: Long) {

    data class ClubItem(val club: ClubDetails) : ClubAdapterData(club.id)

    object ResultHeaderItem : ClubAdapterData(-R.id.list_item_result_header.toLong())

    data class ResultItem(val result: ResultSummary) : ClubAdapterData(result.eventId)

    object EntryHeaderItem : ClubAdapterData(-R.id.list_item_entry_header.toLong())

    data class EntryItem(val entry: EntrySummary) : ClubAdapterData(entry.eventId)
}
