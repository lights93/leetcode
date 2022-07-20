import java.util.Deque
import java.util.LinkedList

class Solution {
    fun numMatchingSubseq(s: String, words: Array<String>): Int {
        val map = HashMap<Char, Deque<String>>()

        for (c in 'a' .. 'z') {
            map[c] = LinkedList<String>()
        }

        for (word in words) {
            val queue = map[word[0]]!!
            queue.addLast(word)
        }

        var answer = 0
        for (c in s) {
            val queue = map[c]!!

            repeat(queue.size) {
                val poll = queue.poll()!!
                if(poll.length == 1) {
                    answer++
                } else {
                    map[poll[1]]!!.addLast(poll.substring(1))
                }
            }
        }
        
        return answer
    }
}
