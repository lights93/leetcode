import java.util.*

class Solution {
    private val MODULO = 1_000_000_007L

    fun maxPerformance(n: Int, speed: IntArray, efficiency: IntArray, k: Int): Int {
        val list = (0 until n)
            .map { idx -> Pair(efficiency[idx], speed[idx]) }
            .sortedBy { p -> -p.first }
            .toList()

        val queue = PriorityQueue<Int>(k)

        var s = 0L
        var answer = 0L

        list.forEach {
            if (queue.size >= k) {
                s -= queue.remove()
            }

            queue.add(it.second)
            s += it.second
            answer = maxOf(answer, s * it.first)
        }

        return (answer % MODULO).toInt()
    }
}