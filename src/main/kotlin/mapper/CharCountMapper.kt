package mapper

/**
 * Class that takes String and produce Int.
 */
class CharCountMapper : Mapper<String, Int> {
    /**
     * Takes String as an input and returns length of the string
     * @param param input string
     * @return length of the input string
     */

    override fun map(param: String): Int {
        return param.length
    }
}