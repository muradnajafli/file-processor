package io

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.io.File

class FileReaderTest {

    private lateinit var reader: FileReader
    private lateinit var file: File

    @Before
    fun setup() {
        reader = FileReader()
        file = File("test_file.txt")
        file.writeText("")
    }

    @Test
    fun read_file_empty_sequence() {
        val sequence = reader.read(file)
        assertEquals(0, sequence.count())
    }

    @Test
    fun read_file_not_empty_sequence() {
        file.writeText("line 1\nsecond line\nthird line")
        val sequence = reader.read(file)
        assertEquals(listOf("line 1", "second line", "third line"), sequence.toList())
    }

    @Test
    fun read_file_check_read_line_by_line() {
        file.writeText("single line")
        val sequence = reader.read(file)
        assertEquals("single line", sequence.elementAt(0))
        file.appendText("\nadditional line")
        assertEquals("Read file line by line not entire file", 2, sequence.count())
        assertEquals("additional line", sequence.elementAt(1))
    }
}