package io

import java.io.*

/**
 * Class that is responsible for reading file line by line and send each line as sequence item.
 */
class FileReader {
    /**
     * Read file line by line and transform it to sequence.
     * Do not read full file content and transform it to sequence.
     * In this case method will not be able to process to large files
     * @param file file that needs to be read line by line
     * @return sequence that consist of lines of file
     */
    fun read(file: File): Sequence<String> = TODO()
}