package operator

/**
 * Class that takes Int and produce Int.
 */
class SumTerminateOperator : TerminateOperator<Int, Int> {
    /**
     * Method that terminate input sequence and produce int value equal to sum of each sequence item.
     * @param param input sequence to terminate
     * @return sum of each sequence item
     */
    override fun terminate(param: Sequence<Int>): Int {
        return param.sum()
    }
}