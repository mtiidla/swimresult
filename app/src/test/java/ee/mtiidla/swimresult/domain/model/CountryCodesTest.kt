package ee.mtiidla.swimresult.domain.model

import org.junit.Assert.assertEquals
import org.junit.Test

class CountryCodesTest {

    @Test
    fun test_resolve_iso2_from_iso3() {
        assertEquals("EE", CountryCodes.toIso2("EST"))
    }

    @Test
    fun test_resolve_iso3_from_iso2() {
        assertEquals("EST", CountryCodes.toIso3("EE"))
    }

    @Test
    fun test_resolve_all_iso2_from_iso3() {

        CountryCodes.ISO3.forEachIndexed { index, iso3 ->
            assertEquals(CountryCodes.ISO2[index], CountryCodes.toIso2(iso3))
        }
    }

    @Test
    fun test_resolve_all_iso3_from_iso2() {

        CountryCodes.ISO2.forEachIndexed { index, iso2 ->
            assertEquals(CountryCodes.ISO3[index], CountryCodes.toIso3(iso2))
        }
    }
}