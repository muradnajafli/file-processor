package operator

interface TerminateOperator<in P, out R> {
    /**
     * Method that terminates input sequence and produces the result of the terminated operation.
     * @param param input sequence to terminate
     * @return value of the terminated operation
     */
    fun terminate(param: Sequence<P>): R
}