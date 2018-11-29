package ee.mtiidla.swimresult.domain.model

data class AgeGroupResults(
    val id: Long,
    val results: List<Result>,
    val ageGroup: AgeGroup? = null // TODO: Marko 29.11.2018 what to do with fields that are combined by multiple requests
)