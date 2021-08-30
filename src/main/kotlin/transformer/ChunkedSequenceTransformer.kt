package transformer

/**
 * Class that can take any type and produce List<InputType>, where InputType is alias for input type.
 */
class ChunkedSequenceTransformer(
    private val chunkSize: Int
) : SequenceTransformer {
    /**
     * Takes sequence and produces a chunked sequence of the same type. Chunk size is equal to chunkSize.
     * @param source initial sequence
     * @return chunked sequence with the same type as the input sequence
     */
    override fun transform(source: ) = TODO()
}