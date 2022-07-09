import java.util.*

class Solution {
    fun maxResult(nums: IntArray, k: Int): Int {
        val beforeList = LinkedList<Int>()
        beforeList.add(0)
        for (i in 1 until nums.size) {
            nums[i] += nums[beforeList.first()]

            while (beforeList.isNotEmpty() && nums[beforeList[beforeList.lastIndex]] <= nums[i]) {
                beforeList.removeLast()
            }

            beforeList.add(i)

            if(beforeList[0] == i - k) {
                beforeList.removeFirst()
            }
        }

        return nums[nums.lastIndex]
    }
}