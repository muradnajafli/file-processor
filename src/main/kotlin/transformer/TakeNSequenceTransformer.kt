package transformer

/**
 * Class that can take any type and produce the same type.
 */
class TakeNSequenceTransformer(private val numberToTake: Int): SequenceTransformer {
    /**
     * Method that takes sequence and produce sequence that takes only numberToTake items from initial sequence.
     * @param source initial sequence
     * @return sequence with the same type as initial that contains only numberToTake items
     */
    override fun transform(source: ) = TODO()
}