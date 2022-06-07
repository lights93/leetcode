class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        val newNums1 = nums1.copyOf()
        var idx = 0
        var idx1 = 0
        var idx2 = 0

        while (idx1 < m && idx2 < n) {
            val num1 = newNums1[idx1]
            val num2 = nums2[idx2]

            if (num1 < num2) {
                nums1[idx++] = num1
                idx1++
            } else {
                nums1[idx++] = num2
                idx2++
            }
        }

        while(idx1 < m) {
                nums1[idx++] = newNums1[idx1]
                idx1++
        }

        while(idx2 < n) {
            nums1[idx++] = nums2[idx2]
            idx2++
        }
    }
}