package filter

/**
 * Class should filter only strings.
 */
class LineLengthFilter(private val lengthLimit: Int) : Filter<String> {
    /**
     * @param value input string represents line of file
     * @return true if length of param is less or equal to lengthLimit
     */
    override fun filter(value: String): Boolean {
        return value.length <= lengthLimit
    }
}