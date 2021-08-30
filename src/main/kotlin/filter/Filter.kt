package filter

/**
 * The filter should be able to take any type as an argument.
 */
interface Filter {
    /**
     * Method that will process sequence items one by one.
     * When return value is true item will be emitted further otherwise it will not
     */
    fun filter(value: ): Boolean
}