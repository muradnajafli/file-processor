package transformer

/**
 * Class that can take any type and produce List<InputType>, where InputType is alias for input type.
 */
class ChunkedSequenceTransformer<InputType>(
    private val chunkSize: Int
) : SequenceTransformer<InputType, List<InputType>> {
    /**
     * Takes sequence and produce chunked sequence of the same type. Chunk size is equal to chunkSize.
     * @param source initial sequence
     * @return chunked sequence with the same type as input sequence
     */
    override fun transform(source: Sequence<InputType>): Sequence<List<InputType>> {
        return source.chunked(chunkSize)
    }
}