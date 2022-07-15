class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var answer = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                answer = maxOf(answer, solve(grid, i, j))
            }
        }

        return answer
    }

    private fun solve(grid: Array<IntArray>, i: Int, j: Int): Int {
        if (i < 0 || i >= grid.size || j < 0 || j >= grid[0].size || grid[i][j] == 0) {
            return 0
        }

        var sum = 1

        grid[i][j] = 0
        sum += solve(grid, i + 1, j)
        sum += solve(grid, i - 1, j)
        sum += solve(grid, i, j + 1)
        sum += solve(grid, i, j - 1)

        return sum
    }
}