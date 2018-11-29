package ee.mtiidla.swimresult.domain.model

data class EventInfo(
    val event: Event,
    val entries: List<Entry>?,
    val heats: List<Heat>?
)