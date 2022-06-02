class Solution {
    fun transpose(matrix: Array<IntArray>): Array<IntArray> {
        val answer = Array(matrix[0].size) {
            IntArray(matrix.size)
        }

        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                answer[j][i] = matrix[i][j]
            }
        }

        return answer
    }
}