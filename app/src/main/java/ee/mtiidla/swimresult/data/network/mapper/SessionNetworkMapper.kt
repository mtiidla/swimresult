package ee.mtiidla.swimresult.data.network.mapper

import ee.mtiidla.swimresult.data.network.model.SessionNetworkModel
import ee.mtiidla.swimresult.domain.model.Course
import ee.mtiidla.swimresult.domain.model.Session
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalTime
import javax.inject.Inject

class SessionNetworkMapper @Inject constructor(
    private val eventMapper: SessionEventNetworkMapper
) : NetworkMapper<SessionNetworkModel, Session> {

    override fun map(item: SessionNetworkModel): Session = with(item) {
        Session(
            name = name,
            day = day,
            time = LocalTime.parse(time),
            date = LocalDate.parse(date),
            number = number,
            course = mapCourse(course),
            events = eventMapper.map(events)
        )
    }

    private fun mapCourse(course: String): Course = when (course) {
        "1" -> Course.LCM
        "2" -> Course.SCM
        else -> Course.OTHER
    }
}