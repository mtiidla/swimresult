package ee.mtiidla.swimresult.ui.athlete

import ee.mtiidla.swimresult.R
import ee.mtiidla.swimresult.domain.model.AthleteDetails
import ee.mtiidla.swimresult.domain.model.EntrySummary
import ee.mtiidla.swimresult.domain.model.ResultSummary

sealed class AthleteAdapterData(val id: Long) {

    data class AthleteItem(val athlete: AthleteDetails) : AthleteAdapterData(athlete.id)

    object ResultHeaderItem : AthleteAdapterData(-R.id.list_item_result_header.toLong())

    data class ResultItem(val result: ResultSummary) : AthleteAdapterData(result.eventId)

    object EntryHeaderItem : AthleteAdapterData(-R.id.list_item_entry_header.toLong())

    data class EntryItem(val entry: EntrySummary) : AthleteAdapterData(entry.eventId)
}
