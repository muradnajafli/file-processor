package filter

/**
 * Class should filter only strings.
 */
class WordsNumberFilter(private val wordLimit: Int) : Filter {
    /**
     * @param value input string represents line of file
     * @return true if array that equal to param split by single space has size less or equal to wordLimit
     */
    override fun filter(value: ) = TODO()
}