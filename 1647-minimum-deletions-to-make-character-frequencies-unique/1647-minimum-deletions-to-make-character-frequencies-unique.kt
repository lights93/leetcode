import java.util.*

class Solution {
    fun minDeletions(s: String): Int {
        val countMap = s.groupingBy { it }.eachCount()

        val queue: PriorityQueue<Pair<Int, Char>> = PriorityQueue { p1, p2 -> p2.first.compareTo(p1.first) }

        countMap.entries
            .forEach { queue.add(Pair(it.value, it.key)) }

        var answer = 0
        var before = queue.poll()
        while (queue.isNotEmpty()) {
            val poll = queue.poll()
            if (before.first == poll.first) {
                answer++
                if(poll.first > 1) {
                    queue.add(Pair(poll.first - 1, poll.second))
                }
            } else {
                before = poll
            }
        }

        return answer
    }
}