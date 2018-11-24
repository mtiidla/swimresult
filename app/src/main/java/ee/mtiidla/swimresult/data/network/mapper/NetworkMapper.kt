package ee.mtiidla.swimresult.data.network.mapper

interface NetworkMapper<T, R> {

    fun map(item: T): R

    fun map(item: List<T>): List<R> = item.map { map(it) }
}