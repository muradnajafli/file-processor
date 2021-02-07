package mapper

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class NumberWordsMapperTest {

    private lateinit var mapper: NumberWordsMapper

    @Before
    fun setup() {
        mapper = NumberWordsMapper()
    }

    @Test
    fun map_empty_string() {
        Assert.assertEquals(0, mapper.map(""))
    }

    @Test
    fun map_white_space_string() {
        Assert.assertEquals(0, mapper.map("  "))
    }

    @Test
    fun map_blank_string() {
        Assert.assertEquals(0, mapper.map("\t  "))
    }

    @Test
    fun map_single_word_white_space_string() {
        Assert.assertEquals(1, mapper.map("  word  "))
    }

    @Test
    fun map_single_word_white_space_tab_string() {
        Assert.assertEquals(1, mapper.map("\tword\t"))
    }

    @Test
    fun map_not_empty_string() {
        val s = "some string"
        Assert.assertEquals(2, mapper.map(s))
    }
}