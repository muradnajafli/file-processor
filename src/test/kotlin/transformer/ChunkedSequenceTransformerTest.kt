package transformer

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ChunkedSequenceTransformerTest {
    private lateinit var transformer: ChunkedSequenceTransformer<String>
    companion object {
        const val CHUNK_SIZE = 2
    }

    @Before
    fun setup() {
        transformer = ChunkedSequenceTransformer(CHUNK_SIZE)
    }

    @Test
    fun transform_empty_sequence() {
        val s = sequenceOf<String>()
        val res = transformer.transform(s)
        Assert.assertEquals(0, res.count())
    }

    @Test
    fun transform_less_then_chunk_size_sequence_check_count() {
        val s = sequenceOf("item")
        val res = transformer.transform(s)
        Assert.assertEquals(1, res.count())
    }

    @Test
    fun transform_less_then_chunk_size_sequence_check_content() {
        val s = sequenceOf("item")
        val res = transformer.transform(s)
        Assert.assertEquals(listOf(listOf("item")), res.toList())
    }

    @Test
    fun transform_more_then_chunk_size_sequence_check_count() {
        val s = sequenceOf("item", "item2", "item3")
        val res = transformer.transform(s)
        Assert.assertEquals(2, res.count())
    }

    @Test
    fun transform_more_then_chunk_size_sequence_check_content() {
        val s = sequenceOf("item", "item2", "item3")
        val res = transformer.transform(s)
        Assert.assertEquals(listOf(listOf("item", "item2"), listOf("item3")), res.toList())
    }
}