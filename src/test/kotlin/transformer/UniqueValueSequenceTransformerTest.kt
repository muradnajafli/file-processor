package transformer

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class UniqueValueSequenceTransformerTest {
    private lateinit var transformer: UniqueValueSequenceTransformer<Int>

    @Before
    fun setup() {
        transformer = UniqueValueSequenceTransformer()
    }

    @Test
    fun transform_empty_sequence() {
        val s = emptySequence<Int>()
        val res = transformer.transform(s)
        assertEquals(0, res.count())
    }

    @Test
    fun transform_single_item_sequence() {
        val s = sequenceOf(1)
        val res = transformer.transform(s)
        assertEquals(listOf(1), res.toList())
    }

    @Test
    fun transform_multiple_item_single_unique_sequence() {
        val s = sequenceOf(1, 1, 1, 1, 1)
        val res = transformer.transform(s)
        assertEquals(listOf(1), res.toList())
    }

    @Test
    fun transform_multiple_item_multiple_unique_sequence() {
        val s = sequenceOf(2, 1, 2, 1, 2)
        val res = transformer.transform(s)
        assertEquals(listOf(2, 1), res.toList())
    }
}