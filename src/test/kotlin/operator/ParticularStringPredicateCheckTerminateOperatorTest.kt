package operator

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ParticularStringPredicateCheckTerminateOperatorTest {
    private lateinit var operator: ParticularStringPredicateCheckTerminateOperator

    companion object {
        const val STRING_TO_CHECK = "string"
    }

    @Before
    fun setup() {
        operator = ParticularStringPredicateCheckTerminateOperator(STRING_TO_CHECK)
    }

    @Test
    fun check_empty_sequence() {
        val s = sequenceOf<String>()
        assertFalse(operator.terminate(s))
    }

    @Test
    fun check_not_empty_no_string_sequence() {
        val s = sequenceOf("wrong string")
        assertFalse(operator.terminate(s))
    }

    @Test
    fun check_not_empty_contains_sequence() {
        val s = sequenceOf("string")
        assertTrue(operator.terminate(s))
    }

    @Test
    fun check_not_empty_contains_not_in_all_sequence() {
        val s = sequenceOf("string", "wrong string")
        assertTrue(operator.terminate(s))
    }
}