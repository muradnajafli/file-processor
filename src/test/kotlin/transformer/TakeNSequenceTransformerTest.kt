package transformer

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class TakeNSequenceTransformerTest {
    private lateinit var transformer: TakeNSequenceTransformer<Int>

    companion object {
        const val ITEMS_TO_TAKE = 2
    }

    @Before
    fun setup() {
        transformer = TakeNSequenceTransformer(ITEMS_TO_TAKE)
    }

    @Test
    fun take_empty_sequence() {
        val s = emptySequence<Int>()
        val res = transformer.transform(s)
        assertEquals(emptyList<Int>(), res.toList())
    }

    @Test
    fun take_not_empty_less_than_max_to_take_sequence() {
        val s = sequenceOf(1)
        val res = transformer.transform(s)
        assertEquals(listOf(1), res.toList())
    }

    @Test
    fun take_not_empty_equal_to_max_to_take_sequence() {
        val s = sequenceOf(1, 2)
        val res = transformer.transform(s)
        assertEquals(listOf(1, 2), res.toList())
    }

    @Test
    fun take_not_empty_more_than_to_max_to_take_sequence() {
        val s = sequenceOf(1, 2, 3, 4)
        val res = transformer.transform(s)
        assertEquals(listOf(1, 2), res.toList())
    }

}