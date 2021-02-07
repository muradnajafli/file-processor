package mapper

/**
 * Class that takes String and produce String.
 */
class ReplacementMapper(
    private val substringToReplace: String,
    private val replacement: String
) : Mapper {
    /**
     * Takes string as an input and produce string that replaces all occurrences of substringToReplace on replacement.
     * @param param input string
     * @return string that contains replacement instead of substringToReplace for all occurrences
     */
    override fun map(param: ) = TODO()
}