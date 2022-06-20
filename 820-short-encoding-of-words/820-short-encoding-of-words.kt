class Solution {
    fun minimumLengthEncoding(words: Array<String>): Int {
        val list = words.distinct()
            .sortedBy { it.length }
            .reversed()

        val set = mutableSetOf<String>()
        for (s in list) {
            if(set.none { it.endsWith(s) }) {
                set.add(s)
            }
        }

        return set.size + set.map { it.length }.sum()
    }
}