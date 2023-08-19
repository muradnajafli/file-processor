package transformer

/**
 * Class that can take any type and produce the same type.
 */
class DropByPredicateSequenceTransformer<T>(private val predicate: (T) -> Boolean ): SequenceTransformer<T, T> {
    /**
     * Method that takes sequence and drop all items until predicate returns true.
     * All items from item for which predicate is false should be emitted in result sequence.
     * Item for which predicate is false should be included in result sequence
     * @param source initial sequence
     * @return sequence with the same type as initial with dropped items by predicate until predicate returns false
     */
    override fun transform(source: Sequence<T>): Sequence<T> {
        return source.dropWhile { predicate(it) }
    }
}