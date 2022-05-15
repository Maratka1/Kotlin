import Brackets.validateParentheses
import org.junit.Assert
import org.junit.Test

class BracketsTest1 {
    @Test
    fun checkTwoPairs() {
        val input = "[][]"
        Assert.assertEquals(0, validateParentheses(input).toLong())
    }

    @Test
    fun checkBigString() {
        val input = "()()(()[[]()])[][][]"
        Assert.assertEquals(0, validateParentheses(input).toLong())
    }
}