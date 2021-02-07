package operator

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class SumTerminateOperatorTest {
    private lateinit var operator: SumTerminateOperator

    @Before
    fun setup() {
        operator = SumTerminateOperator()
    }

    @Test
    fun sum_empty_sequence() {
        val s = sequenceOf<Int>()
        val res = operator.terminate(s)
        assertEquals(0, res)
    }

    @Test
    fun sum_single_number_sequence() {
        val s = sequenceOf(1)
        val res = operator.terminate(s)
        assertEquals(1, res)
    }

    @Test
    fun sum_multiple_numbers_sequence() {
        val s = sequenceOf(1, 2, 3, 4, 5)
        val res = operator.terminate(s)
        assertEquals(15, res)
    }

    @Test
    fun sum_multiple_numbers_with_zero_sequence() {
        val s = sequenceOf(1, 2, 3, 4, 5, 0)
        val res = operator.terminate(s)
        assertEquals(15, res)
    }
}