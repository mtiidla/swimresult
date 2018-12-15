package ee.mtiidla.swimresult.domain.model

data class SessionEvent(
    val status: Event.Status,
    val id: Long
)