package transformer

interface SequenceTransformer<T, R> {
    /**
     * Method that takes one sequence do some transformation with it and returns another sequence
     * @param source sequence to transform
     * @return transformed sequence
     */
    fun transform(source: Sequence<T>): Sequence<R>
}