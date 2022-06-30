import kotlin.math.abs

class Solution {
    fun minMoves2(nums: IntArray): Int {
        nums.sort()

        val mid = nums[nums.size / 2]

        return nums.map { abs(mid - it) }
            .sum()
    }
}