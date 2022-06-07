class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var tail1 = m - 1
        var tail2 = n - 1
        var idx = m + n - 1
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[idx--] = if(nums1[tail1] > nums2[tail2]) {
                nums1[tail1--]
            } else {
                nums2[tail2--]
            }
        }
        
        while (tail2 >= 0) {
            nums1[idx--] = nums2[tail2--]
        }
    }
}