package transformer

/**
 * Class that can take any type and produce the same type.
 */
class UniqueValueSequenceTransformer<T> : SequenceTransformer<T, T> {
    /**
     * Method that takes sequence and produce sequence with unique values from initial sequence.
     * @param source initial sequence
     * @return sequence with unique values from initial sequence
     */
    override fun transform(source: Sequence<T>): Sequence<T> {
        return source.distinct()
    }
}