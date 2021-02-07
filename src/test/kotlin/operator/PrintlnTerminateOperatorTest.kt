package operator

import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class PrintlnTerminateOperatorTest {
    private lateinit var operator: PrintlnTerminateOperator<String>
    private lateinit var outputStream: ByteArrayOutputStream

    @Before
    fun setup() {
        operator = PrintlnTerminateOperator()
        outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
    }

    @Test
    fun empty_sequence() {
        val s = emptySequence<String>()
        operator.terminate(s)
        assertArrayEquals(byteArrayOf(), outputStream.toByteArray())
    }

    @Test
    fun single_item_sequence() {
        val s = sequenceOf("item")
        operator.terminate(s)
        assertEquals("item\n", String(outputStream.toByteArray()))
    }

    @Test
    fun two_items_sequence() {
        val s = sequenceOf("item", "item2")
        operator.terminate(s)
        assertEquals("item\nitem2\n", String(outputStream.toByteArray()))
    }
}