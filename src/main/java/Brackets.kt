import java.lang.Exception
import java.util.*
import kotlin.Throws
import kotlin.jvm.JvmStatic

object Brackets {
    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val `in` = Scanner(System.`in`)
        val str = `in`.nextLine()
        validateParentheses(str)
    }

    @JvmStatic
    fun validateParentheses(input: String): Int {
        val index = 0
        val symbols = input.toCharArray()
        val stack = Stack<Char>()
        var counter = 0
        val opened: MutableList<Int> = LinkedList()
        val closed = LinkedList<Int>()
        for (c in symbols) {
            counter++
            if (c == '(' || c == '{' || c == '[' || c == '<') {
                stack.push(c)
                opened.add(counter)
            }
            if (c == ')' || c == '}' || c == ']' || c == '>') {
                if (!stack.isEmpty()) {
                    val fromStack = stack.peek()
                    if (c == ')' && fromStack == '(' ||
                        c == '}' && fromStack == '{' ||
                        c == ']' && fromStack == '[' ||
                        c == '>' && fromStack == '<'
                    ) {
                        stack.pop()
                        (opened as LinkedList<Int>).removeLast()
                    } else {
                        closed.add(counter)
                        break
                    }
                } else {
                    stack.add(c)
                    closed.add(counter)
                    break
                }
            }
        }
        if (!stack.isEmpty()) {
            if (!closed.isEmpty()) {
                println(closed.first)
            } else {
                if (!opened.isEmpty()) {
                    println((opened as LinkedList<Int>).first)
                }
            }
        } else {
            println("Success")
        }
        return index
    }
}