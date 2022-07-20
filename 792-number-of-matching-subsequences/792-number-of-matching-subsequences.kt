class Solution {
    fun numMatchingSubseq(s: String, words: Array<String>): Int {
        return words.filter { find(it, s) }
            .count()
    }

    private fun find(word: String, s: String): Boolean {
        var start = 0
        for (c in word) {
            val idx = s.indexOf(char = c, startIndex = start)
            if (idx < 0) {
                return false
            }
            start = idx + 1
        }
        return true
    }
}
