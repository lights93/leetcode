import java.util.PriorityQueue

class Solution {
    fun candy(ratings: IntArray): Int {
        val queue = ratings.indices
            .map { Pair(it, ratings[it]) }
            .toCollection(PriorityQueue {p1, p2 ->
                p1.second - p2.second
            })

        val candies = IntArray(ratings.size)

        while (queue.isNotEmpty()) {
            val (idx, rating) = queue.poll()
            var max = 0
            if(idx > 0 && rating > ratings[idx - 1]) {
                max = maxOf(max, candies[idx - 1])
            }
            if(idx < ratings.size - 1 && rating > ratings[idx + 1]) {
                max = maxOf(max, candies[idx + 1])
            }
            
            candies[idx] = max + 1
        }

        return candies.sum()
    }
}