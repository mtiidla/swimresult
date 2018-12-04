package ee.mtiidla.swimresult.domain.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class CountryCodesTest {

    @Test
    fun test_resolve_iso2_from_fina3() {
        assertEquals("EE", CountryCodes.toIso2("EST"))
    }

    @Test
    fun test_resolve_fina3_from_iso2() {
        assertEquals("EST", CountryCodes.toFina3("EE"))
    }

    @Test
    fun test_resolve_all_iso2_from_fina3() {

        CountryCodes.FINA_3.forEachIndexed { index, fina3 ->
            assertEquals(CountryCodes.ISO2[index], CountryCodes.toIso2(fina3))
        }
    }

    @Test
    fun test_resolve_all_fina3_from_iso2() {

        CountryCodes.ISO2.forEachIndexed { index, iso2 ->
            assertEquals(CountryCodes.FINA_3[index], CountryCodes.toFina3(iso2))
        }
    }

    @Test
    fun test_is_valid_fina3_valid_input() {

        assertTrue(CountryCodes.isValidFinaCountry("EST"))
    }

    @Test
    fun test_is_valid_fina3_invalid_input() {

        assertFalse(CountryCodes.isValidFinaCountry("ABC"))
    }
}