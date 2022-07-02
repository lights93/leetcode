import java.math.BigInteger

class Solution {
    fun maxArea(h: Int, w: Int, horizontalCuts: IntArray, verticalCuts: IntArray): Int {
        val modulo = 1_000_000_007L
        val horizons = horizontalCuts.toList().sorted().toMutableList()
        horizons.add(h)

        var before = 0

        var maxHeight = 0
        for (horizon in horizons) {
            val diff = horizon - before
            maxHeight = maxOf(maxHeight, diff)
            before = horizon
        }

        val verticals = verticalCuts.toList().sorted().toMutableList()
        verticals.add(w)

        before = 0
        var maxWidth = 0
        for (vertical in verticals) {
            val diff = vertical - before
            maxWidth = maxOf(maxWidth, diff)
            before = vertical
        }
        
        val answer = BigInteger.valueOf( maxHeight.toLong())
            .multiply(BigInteger.valueOf(maxWidth.toLong()))
            .remainder(BigInteger.valueOf(modulo))
        
        return answer.toInt()
    }
}