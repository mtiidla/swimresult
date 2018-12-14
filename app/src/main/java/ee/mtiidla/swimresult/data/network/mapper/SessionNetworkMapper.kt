package ee.mtiidla.swimresult.data.network.mapper

import ee.mtiidla.swimresult.data.network.model.SessionNetworkModel
import ee.mtiidla.swimresult.domain.model.Course
import ee.mtiidla.swimresult.domain.model.Session
import javax.inject.Inject

class SessionNetworkMapper @Inject constructor(
    private val eventMapper: SessionEventNetworkMapper
) : NetworkMapper<SessionNetworkModel, Session> {

    override fun map(item: SessionNetworkModel): Session = with(item) {
        Session(
            name = name,
            day = day,
            time = mapTime(time),
            date = mapDate(date),
            number = number,
            course = mapCourse(course),
            events = eventMapper.map(events)
        )
    }
}