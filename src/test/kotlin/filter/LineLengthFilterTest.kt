package filter

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class LineLengthFilterTest {
    private lateinit var filter: LineLengthFilter

    private companion object {
        const val LINE_LENGTH_LIMIT = 10
    }

    @Before
    fun setup() {
        filter = LineLengthFilter(LINE_LENGTH_LIMIT)
    }

    @Test
    fun filter_empty_string() {
        assertTrue(filter.filter(""))
    }

    @Test
    fun filter_short_string() {
        assertTrue(filter.filter("short"))
    }

    @Test
    fun filter_exact_limit_string() {
        assertTrue(filter.filter("10 symbols"))
    }

    @Test
    fun filter_long_string() {
        assertFalse(filter.filter("too long string"))
    }

}