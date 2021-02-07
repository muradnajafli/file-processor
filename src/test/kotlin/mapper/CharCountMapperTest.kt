package mapper

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CharCountMapperTest {

    private lateinit var mapper: CharCountMapper

    @Before
    fun setup() {
        mapper = CharCountMapper()
    }

    @Test
    fun map_empty_string() {
        assertEquals(0, mapper.map(""))
    }

    @Test
    fun map_not_empty_string() {
        val s = "some string"
        assertEquals(s.length, mapper.map(s))
    }
}