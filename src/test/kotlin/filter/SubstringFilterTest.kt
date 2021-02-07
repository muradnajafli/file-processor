package filter

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class SubstringFilterTest {

    private lateinit var substringFilter: SubstringFilter

    private companion object {
        const val MANDATORY_STRING = "string"
    }

    @Before
    fun setup() {
        substringFilter = SubstringFilter(MANDATORY_STRING)
    }

    @Test
    fun filter_empty_string() {
        assertFalse(substringFilter.filter(""))
    }

    @Test
    fun filter_equal_string() {
        assertTrue(substringFilter.filter(MANDATORY_STRING))
    }

    @Test
    fun filter_contains_string() {
        assertTrue(substringFilter.filter("presented string"))
    }

    @Test
    fun filter_contains_ignore_case_string() {
        assertFalse(substringFilter.filter("sTring"))
    }

    @Test
    fun filter_not_contains_string() {
        assertFalse(substringFilter.filter("no value"))
    }
}