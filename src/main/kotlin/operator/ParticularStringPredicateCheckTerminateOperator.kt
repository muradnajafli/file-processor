package operator

/**
 * Class that takes String and produce Boolean.
 */
class ParticularStringPredicateCheckTerminateOperator(
    private val stringToCheck: String
) : TerminateOperator<String, Boolean> {
    /**
     * Method that finds first item in sequence equal to stringToCheck property
     * @param param sequence to terminate
     * @return true if sequence contains item equal to stringToCheck property false otherwise
     */
    override fun terminate(param: Sequence<String>): Boolean {
        return param.contains(stringToCheck)
    }
}