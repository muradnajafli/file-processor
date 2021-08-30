package mapper

/**
 * Class that takes String and produces String.
 */
class ReplacementMapper(
    private val substringToReplace: String,
    private val replacement: String
) : Mapper {
    /**
     * Take string as an input and produce string that replaces all occurrences of substringToReplace on replacement.
     * @param param input string
     * @return string that contains replacement instead of substringToReplace for all occurrences
     */
    override fun map(param: ) = TODO()
}