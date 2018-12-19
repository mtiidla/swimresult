package ee.mtiidla.swimresult.ui.athlete

import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.AthleteDetails
import ee.mtiidla.swimresult.domain.model.EntrySummary
import ee.mtiidla.swimresult.domain.model.ResultSummary

sealed class AthleteData(val id: Long) {

    data class AthleteItem(val athlete: AthleteDetails) : AthleteData(athlete.id)

    object ResultHeaderItem : AthleteData(-R.id.list_item_result_header.toLong())

    data class ResultItem(val result: ResultSummary) : AthleteData(result.eventId)

    object EntryHeaderItem : AthleteData(-R.id.list_item_entry_header.toLong())

    data class EntryItem(val entry: EntrySummary) : AthleteData(entry.eventId)
}
