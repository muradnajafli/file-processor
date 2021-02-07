import filter.Filter
import io.FileReader
import io.mockk.Called
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import mapper.Mapper
import operator.TerminateOperator
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test
import transformer.SequenceTransformer
import java.io.File

class FileProcessorTest {
    private lateinit var processor: FileProcessor
    private lateinit var reader: FileReader
    private lateinit var mapper: Mapper<String, Int>
    private lateinit var filter: Filter<String>
    private lateinit var transformer: SequenceTransformer<Int, Number>
    private lateinit var operator: TerminateOperator<Number, Boolean>

    @Before
    fun setup() {
        reader = mockk()
        mapper = mockk()
        filter = mockk()
        transformer = mockk()
        operator = mockk()
        processor = FileProcessor(reader)
    }

    @Test
    fun process_check_pipeline_result() {
        val mockFile = mockk<File>()
        val fileSequence = mockk<Sequence<String>>()
        val processedSequence = mockk<Sequence<Int>>()
        every { reader.read(mockFile) } returns fileSequence
        every { transformer.transform(any()) } returns processedSequence
        every { operator.terminate(processedSequence) } returns false
        val result = processor.process(mockFile, filter, mapper, transformer, operator)
        assertFalse(result)
    }

    @Test
    fun process_zero_lines_emitted_check_invocation() {
        val mockFile = mockk<File>()
        val fileSequence = mockk<Sequence<String>>()
        val processedSequence = mockk<Sequence<Int>>()
        every { reader.read(mockFile) } returns fileSequence
        every { transformer.transform(any()) } returns processedSequence
        every { operator.terminate(processedSequence) } returns false
        processor.process(mockFile, filter, mapper, transformer, operator)
        verify(exactly = 1) {
            reader.read(mockFile)
            operator.terminate(processedSequence)
            transformer.transform(any())
            filter wasNot Called
            mapper wasNot Called
        }
    }

    @Test
    fun process_multiple_lines_emitted_single_filtered_check_invocation() {
        val mockFile = mockk<File>()
        val item1 = "item1"
        val mappedItem1 = 1
        val item2 = "item2"
        val fileSequence = sequenceOf(item1, item2)
        val processedSequence = mockk<Sequence<Int>>()
        every { reader.read(mockFile) } returns fileSequence

        every { filter.filter(item1) } returns true
        every { filter.filter(item2) } returns false

        every { mapper.map(item1) } returns mappedItem1

        every { transformer.transform(any()) } answers {
            value.toList() // trigger terminate operator
            processedSequence
        }
        every { operator.terminate(processedSequence) } returns false
        processor.process(mockFile, filter, mapper, transformer, operator)
        verify(exactly = 1) {
            reader.read(mockFile)
            operator.terminate(processedSequence)
            transformer.transform(any())
            filter.filter(item1)
            filter.filter(item2)
            mapper.map(item1)
        }
    }

    @Test
    fun process_multiple_lines_emitted_multiple_filtered_check_invocation() {
        val mockFile = mockk<File>()
        val item1 = "item1"
        val mappedItem1 = 1
        val item2 = "item2"
        val mappedItem2 = 2
        val fileSequence = sequenceOf(item1, item2)
        val processedSequence = mockk<Sequence<Int>>()
        every { reader.read(mockFile) } returns fileSequence

        every { filter.filter(item1) } returns true
        every { filter.filter(item2) } returns true

        every { mapper.map(item1) } returns mappedItem1
        every { mapper.map(item2) } returns mappedItem2

        every { transformer.transform(any()) } answers {
            value.toList() // trigger terminate operator
            processedSequence
        }
        every { operator.terminate(processedSequence) } returns false
        processor.process(mockFile, filter, mapper, transformer, operator)
        verify(exactly = 1) {
            reader.read(mockFile)
            operator.terminate(processedSequence)
            transformer.transform(any())
            filter.filter(item1)
            filter.filter(item2)
            mapper.map(item1)
            mapper.map(item2)
        }
    }
}