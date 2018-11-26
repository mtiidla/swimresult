package ee.mtiidla.swimresult.data.network.mapper

interface NetworkMapper<T, R> {

    fun map(item: T): R

    fun map(itemList: List<T>): List<R> = itemList.map { map(it) }
}