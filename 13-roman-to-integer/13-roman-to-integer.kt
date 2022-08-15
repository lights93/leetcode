class Solution {
    fun romanToInt(s: String): Int {
        val reversed = s.reversed()

        var answer = 0
        var order = 0

        for (i in reversed.indices) {
            val roman = Roman.valueOf(reversed.substring(i, i + 1))
            if (roman.ordinal < order) {
                answer -= roman.num
            } else {
                answer += roman.num
            }
            order = roman.ordinal
        }

        return answer
    }
}

enum class Roman(val num: Int) {
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000),
}