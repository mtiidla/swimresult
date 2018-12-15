package ee.mtiidla.swimresult.data.network.mapper

import ee.mtiidla.swimresult.data.network.model.EventNetworkModel
import ee.mtiidla.swimresult.domain.model.Event
import ee.mtiidla.swimresult.domain.model.Stroke
import ee.mtiidla.swimresult.util.whenNotNull
import javax.inject.Inject

class EventNetworkMapper @Inject constructor() : NetworkMapper<EventNetworkModel, Event> {

    override fun map(item: EventNetworkModel): Event = with(item) {
        Event(
            id = id.toLong(),
            number = number,
            stroke = whenNotNull(stroke) { mapStroke(it.toInt()) } ?: Stroke.OTHER,
            styleName = stylename,
            distance = distance,
            gender = mapGender(gender),
            relay = isrelay,
            time = mapTime(time),
            date = mapDateSafe(date),
            round = mapRound(round.toInt())
        )
    }

    private fun mapStroke(code: Int): Stroke = when (code) {
        1 -> Stroke.FREE
        2 -> Stroke.BACK
        3 -> Stroke.BREAST
        4 -> Stroke.FLY
        5 -> Stroke.IM
        else -> Stroke.OTHER
    }

    private fun mapRound(round: Int): Event.Round = when (round) {
        1 -> Event.Round.TIMED_FINAL
        2 -> Event.Round.PRELIM
        9 -> Event.Round.FINAL
        else -> Event.Round.UNKNOWN
    }
}