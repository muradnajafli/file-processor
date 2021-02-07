package transformer

/**
 * Class that can take any type and produce the same type.
 */
class DropByPredicateSequenceTransformer(private val predicate: ): SequenceTransformer {
    /**
     * Method that takes sequence and drop all items until predicate returns true.
     * All items from item for which predicate is false should be emitted in result sequence.
     * Item for which predicate is false should be included in result sequence
     * @param source initial sequence
     * @return sequence with the same type as initial with dropped items by predicate until predicate returns false
     */
    override fun transform(source: ) = TODO()
}