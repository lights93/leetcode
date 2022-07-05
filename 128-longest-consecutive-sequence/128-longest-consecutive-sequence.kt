class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val map = mutableMapOf<Int, Pair<Int, Int>>()

        var answer = 0
        for (num in nums) {
            if (!map.containsKey(num)) {
                var low = num
                var high = num
                if (map.containsKey(num + 1)) {
                    var highPair = map[num + 1]!!
                    high = highPair.second
                }

                if (map.containsKey(num - 1)) {
                    var lowPair = map[num - 1]!!
                    low = lowPair.first
                }

                val pair = Pair(low, high)
                map[low] = pair
                map[high] = pair
                map[num] = pair

                answer = maxOf(answer, high - low + 1)
            }
        }

        return answer
    }
}