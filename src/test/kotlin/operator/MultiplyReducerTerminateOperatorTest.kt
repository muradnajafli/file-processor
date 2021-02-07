package operator

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MultiplyReducerTerminateOperatorTest {
    private lateinit var operator: MultiplyReducerTerminateOperator

    @Before
    fun setup() {
        operator = MultiplyReducerTerminateOperator()
    }

    @Test
    fun reduce_empty_sequence() {
        val s = sequenceOf<Int>()
        val res = operator.terminate(s)
        assertEquals(0, res)
    }

    @Test
    fun reduce_single_number_sequence() {
        val s = sequenceOf(1)
        val res = operator.terminate(s)
        assertEquals(1, res)
    }

    @Test
    fun reduce_multiple_numbers_sequence() {
        val s = sequenceOf(1, 2, 3, 4, 5)
        val res = operator.terminate(s)
        assertEquals(120, res)
    }

    @Test
    fun reduce_multiple_numbers_with_zero_sequence() {
        val s = sequenceOf(1, 2, 3, 4, 5, 0)
        val res = operator.terminate(s)
        assertEquals(0, res)
    }
}