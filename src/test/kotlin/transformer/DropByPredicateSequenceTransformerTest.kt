package transformer

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class DropByPredicateSequenceTransformerTest {
    private lateinit var transformer: DropByPredicateSequenceTransformer<Int>

    @Before
    fun setup() {
        transformer = DropByPredicateSequenceTransformer { it % 2 == 0}
    }

    @Test
    fun drop_empty_sequence() {
        val s = emptySequence<Int>()
        val res = transformer.transform(s)
        assertEquals(emptyList<Int>(), res.toList())
    }

    @Test
    fun drop_not_empty_sequence_empty_result() {
        val s = sequenceOf(2, 4, 6)
        val res = transformer.transform(s)
        assertEquals(emptyList<Int>(), res.toList())
    }

    @Test
    fun drop_not_empty_sequence_keep_from_middle_result() {
        val s = sequenceOf(2, 5, 6)
        val res = transformer.transform(s)
        assertEquals(listOf(5, 6), res.toList())
    }

    @Test
    fun drop_not_empty_sequence_keep_last_result() {
        val s = sequenceOf(2, 4, 5)
        val res = transformer.transform(s)
        assertEquals(listOf(5), res.toList())
    }
}