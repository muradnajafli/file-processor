import filter.Filter
import io.FileReader
import mapper.Mapper
import transformer.SequenceTransformer
import operator.TerminateOperator
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
    fun <T, R, B>process(
        file: File,
        filter: Filter<String>,
        mapper: Mapper<String, T>,
        transformer: SequenceTransformer<T, R>,
        terminateOperator: TerminateOperator<R, B>
    ): B {
        return fileReader.read(file)
            .filter(filter::filter)
            .map(mapper::map)
            .let(transformer::transform)
            .let(terminateOperator::terminate)
    }
}