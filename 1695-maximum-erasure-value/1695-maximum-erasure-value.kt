class Solution {
    fun maximumUniqueSubarray(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        var start = 0
        var sum = 0
        var max = 0
        for ((index, num) in nums.withIndex()) {
            sum += num
            if(map.containsKey(num)) {
                val temp = map[num]!!
                for (i in start .. temp) {
                    map.remove(nums[i])
                    sum -= nums[i]
                }
                start = temp + 1
            } else {
                max = maxOf(max, sum)
            }
            map[num] = index
        }

        return max
    }
}