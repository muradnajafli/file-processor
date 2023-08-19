package filter

/**
 * Class should filter only strings.
 */
class SubstringFilter(private val substring: String) : Filter<String> {
    /**
     * @param value input string represents line of file
     * @return true if param contains substring. Check should be case-sensitive
     */
    override fun filter(value: String): Boolean {
        return value.contains(substring.toLowerCase())
    }

}