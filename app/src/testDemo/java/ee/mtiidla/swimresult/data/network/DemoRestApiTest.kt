package ee.mtiidla.swimresult.data.network

import com.squareup.moshi.Moshi
import ee.mtiidla.swimresult.TestFileDataSource
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class DemoRestApiTest {

    private lateinit var restApi: RestApi

    @Before
    fun setUp() {
        restApi = DemoRestApi(Moshi.Builder().build(), TestFileDataSource())
    }

    @Test
    fun testCanLoadFileDataSource() {

        runBlocking {
            val meets = restApi.getMeets().await()
            assertEquals("1.0", meets.version)
        }
    }
}