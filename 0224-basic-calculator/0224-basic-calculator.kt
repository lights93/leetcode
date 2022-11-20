import java.util.*

class Solution {
    fun calculate(s: String): Int {
        val numStacks = Stack<Stack<Int>>()
        val isPositiveStack = Stack<Boolean>()

        numStacks.push(Stack())
        isPositiveStack.push(true)

        var idx = 0
        var isPositive = true

        while (idx < s.length) {
            val c = s[idx]

            when (c) {
                ' ' -> {}
                '+' -> {}
                '-' -> isPositive = !isPositive
                '(' -> {
                    numStacks.add(Stack())
                    isPositiveStack.add(isPositive)
                    isPositive = true
                }
                ')' -> {
                    val sum = numStacks.pop().sum()
                    val currentIsPositive = isPositiveStack.pop()
                    if (currentIsPositive) {
                        numStacks.last().push(sum)
                    } else {
                        numStacks.last().push(-sum)
                    }

                    // println(numStacks)
                    // println()
                }

                else -> {
                    var currentNum = c - '0'
                    while (idx + 1 < s.length && s[idx + 1].isDigit()) {
                        currentNum = currentNum * 10 + (s[idx + 1] - '0')
                        idx++
                    }

                    if (isPositive) {
                        numStacks.last().push(currentNum)
                    } else {
                        numStacks.last().push(-currentNum)
                    }

                    isPositive = true
                }
            }
            idx++
        }
        return numStacks.last().sum()
    }
}