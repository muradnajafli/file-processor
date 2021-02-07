package filter

/**
 * Filter should have a possibility to take any type as argument.
 */
interface Filter {
    /**
     * Method that will process sequence items one by one.
     * When return value is true item will be emitted further otherwise it will not
     */
    fun filter(value: ): Boolean
}