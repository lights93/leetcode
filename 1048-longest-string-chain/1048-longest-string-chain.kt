class Solution {
    fun longestStrChain(words: Array<String>): Int {
        words.sortBy { it.length }
        words.reverse()

        val map = words.associate { Pair(it, 0) }
            .toMutableMap()

        var answer = 0
        for (word in words) {
            answer = maxOf(answer, solve(map, word))
        }

        return answer
    }

    private fun solve(map: MutableMap<String, Int>, word: String): Int {
        if (word.length == 1) {
            return 1
        }

        if (map.getOrDefault(word, 0) > 0) {
            return map.getOrDefault(word, 0);
        }

        var max = 0
        for (i in word.indices) {
            val temp = word.substring(0, i) + word.substring(i + 1)
            if (map.contains(temp)) {
                max = maxOf(solve(map, temp), max)
            }
        }

        map[word] = max + 1

        return max + 1
    }
}