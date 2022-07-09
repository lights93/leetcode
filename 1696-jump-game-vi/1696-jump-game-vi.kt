import java.util.*

class Solution {
    fun maxResult(nums: IntArray, k: Int): Int {
        val queue = ArrayDeque<Int>(k)
        queue.add(0)
        for (i in 1 until nums.size) {
            nums[i] += nums[queue.peekFirst()!!]

            while (queue.isNotEmpty() && nums[queue.peekLast()!!] <= nums[i]) {
                queue.pollLast()
            }
            
            queue.add(i)

            if(queue.peekFirst() == i - k) {
                queue.pollFirst()
            }
        }

        return nums[nums.lastIndex]
    }
}