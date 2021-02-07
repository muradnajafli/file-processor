package filter

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class WordsNumberFilterTest {

    private lateinit var wordsNumberFilter: WordsNumberFilter

    private companion object {
        const val WORDS_NUMBER_LIMIT = 10
    }

    @Before
    fun setup() {
        wordsNumberFilter = WordsNumberFilter(WORDS_NUMBER_LIMIT)
    }

    @Test
    fun empty_string() {
        assertTrue(wordsNumberFilter.filter(""))
    }

    @Test
    fun single_word_string() {
        assertTrue(wordsNumberFilter.filter("word"))
    }

    @Test
    fun empty_words_long_string() {
        assertFalse(wordsNumberFilter.filter("           "))
    }

    @Test
    fun empty_words_exact_limit_string() {
        assertFalse(wordsNumberFilter.filter("          "))
    }

    @Test
    fun empty_words_short_string() {
        assertTrue(wordsNumberFilter.filter("         "))
    }

    @Test
    fun not_empty_words_short_string() {
        assertTrue(wordsNumberFilter.filter("string contains less words than set in limit"))
    }
}