class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        for ((index, number) in numbers.withIndex()) {
            val answer = numbers.binarySearch(target - number, index + 1)
            if (answer > 0) {
                return intArrayOf(index + 1, answer + 1)
            }
        }

        return intArrayOf()
    }
}