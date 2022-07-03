class Solution {
    fun wiggleMaxLength(nums: IntArray): Int {
        val up = IntArray(nums.size)
        val down = IntArray(nums.size)
        up[0] = 1
        down[0] = 1

        nums.indices
            .drop(1)
            .forEach {
                up[it] = up[it - 1]
                down[it] = down[it - 1]

                if(nums[it - 1] > nums[it]) {
                    down[it] = up[it - 1] + 1
                } else if(nums[it -1] < nums[it]) {
                    up[it] = down[it - 1] + 1
                }
            }

        return maxOf(up[up.lastIndex], down[down.lastIndex])
    }
}