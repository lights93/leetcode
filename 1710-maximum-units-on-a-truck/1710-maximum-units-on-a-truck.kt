class Solution {
    fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int {
        boxTypes.sortBy { -it[1] }

        var sum = 0
        var idx = 0
        var size = truckSize
        while (size > 0 && idx < boxTypes.size) {
            val ints = boxTypes[idx]
            if (ints[0] > size) {
                sum += size * ints[1]
                return sum
            }

            sum += ints[0] * ints[1]
            size -= ints[0]
            idx++
        }

        return sum
    }
}