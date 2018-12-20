package ee.mtiidla.swimresult.domain.model

data class AgeGroup(
    val id: Long,
    val key: String?,
    val min: Int,
    val max: Int,
    val name: String?
)