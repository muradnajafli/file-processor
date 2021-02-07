package operator

interface TerminateOperator<in P, out R> {
    /**
     * Method that terminate input sequence and produces result of terminate operation
     * @param param input sequence to terminate
     * @return value of terminated operation
     */
    fun terminate(param: Sequence<P>): R
}