package ee.mtiidla.swimresult.data.network

import com.squareup.moshi.Moshi
import ee.mtiidla.swimresult.TestFileDataSource
import ee.mtiidla.swimresult.data.network.adapter.EventsJsonMapAdapter
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class DemoRestApiTest {

    private lateinit var restApi: RestApi

    @Before
    fun setUp() {
        restApi = DemoRestApi(
            Moshi.Builder()
                .add(EventsJsonMapAdapter())
                .build(), TestFileDataSource()
        )
    }

    @Test
    fun testCanLoadFileDataSource() {

        runBlocking {
            val meets = restApi.getMeets().await()
            assertEquals("1.0", meets.version)
        }
    }

    @Test
    fun testParseJsonMap() {

        runBlocking {

            val events = restApi.getEvents(0).await()

            assertEquals(110, events.events.size)

        }
    }
}