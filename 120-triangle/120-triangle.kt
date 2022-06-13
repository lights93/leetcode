class Solution {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val dp = Array<IntArray>(triangle.size) {
            IntArray(triangle.size)
        }

        dp[0][0] = triangle[0][0]

        for (i in 1 until triangle.size) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0]
            for (j in 1 until i) {
                dp[i][j] = triangle[i][j] + minOf(dp[i - 1][j], dp[i - 1][j - 1])
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i]
        }
        
        return dp[dp.lastIndex].min()!!
    }
}