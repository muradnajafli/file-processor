package mapper

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ReplacementMapperTest {
    private lateinit var mapper: ReplacementMapper

    companion object {
        const val SUBSTRING_TO_REPLACE = "to replace"
        const val REPLACEMENT = "replacement"
    }

    @Before
    fun setup() {
        mapper = ReplacementMapper(SUBSTRING_TO_REPLACE, REPLACEMENT)
    }

    @Test
    fun map_empty_string() {
        assertEquals("", mapper.map(""))
    }

    @Test
    fun map_no_substring() {
        val s = "no string"
        assertEquals(s, mapper.map(s))
    }

    @Test
    fun map_contains_single_substring() {
        val s = "to replace"
        assertEquals(REPLACEMENT, mapper.map(s))
    }

    @Test
    fun map_contains_multiple_substring() {
        val s = "to replace to replace"
        assertEquals("$REPLACEMENT $REPLACEMENT", mapper.map(s))
    }

    @Test
    fun map_contains_multiple_substring_one_mismatch_by_case() {
        val s = "to replace to Replace"
        assertEquals("$REPLACEMENT to Replace", mapper.map(s))
    }
}