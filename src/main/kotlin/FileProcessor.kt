import filter.Filter
import filter.LineLengthFilter
import io.FileReader
import mapper.CharCountMapper
import mapper.Mapper
import operator.SumTerminateOperator
import transformer.SequenceTransformer
import operator.TerminateOperator
import transformer.TakeNSequenceTransformer
import java.io.File

/**
 * Main class that will process file. It takes file reader as constructor argument to read file line by line.
 */
class FileProcessor(private val fileReader: FileReader) {
    /**
     * Method takes file, filter, mapper, transformer and terminate operator.
     * File should be first converted to sequence of String. Each string is equal to line of file
     * Each line of file should go through the following pipeline: filter -> mapper -> transformer.
     * Then output sequence should be terminated by terminate operator.
     * Use fileReader to read file as sequence of lines.
     * Method should accept any string filter, any mapper that takes string and produce another type,
     * any sequence transformer that input type match with mapper output type,
     * any terminate operator that input type match with transformer output type.
     * @param file file to process
     * @param filter any string filter to apply to lines of file
     * @param mapper any mapper that map String to another type. Mapping will be done for each filtered file line
     * @param transformer any transformer that will change mapped sequence to another sequence
     * @param terminateOperator any terminate operator that input type match with transformer output type.
     * @return result of terminated operator.
     */
    fun process(
        file: File,
        filter: Filter,
        mapper: Mapper,
        transformer: SequenceTransformer,
        terminateOperator: TerminateOperator
    ) = TODO()
}

/**
 * Uncomment main function to check entire pipeline.
 * In case everything is implemented correctly and there is no changes in test_file.txt '6' will be printed to console.
 */
/*
fun main() {
    val file = File("src/main/resources/test_file.txt")
    val processor = FileProcessor(FileReader())
    val result: Int = processor.process(
        file = file,
        filter = LineLengthFilter(12),
        mapper = CharCountMapper(),
        transformer = TakeNSequenceTransformer(5),
        terminateOperator = SumTerminateOperator()
    )
    println(result) // With no changes in test file result should be equal to 6
}
*/
