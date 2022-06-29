class Solution {
    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        people.sortWith(kotlin.Comparator { o1, o2 ->
            if (o1[0] == o2[0]) {
                o1[1].compareTo(o2[0])
            }
            o1[0].compareTo(o2[0])
        })

        val result = Array(people.size) {
            intArrayOf(Int.MAX_VALUE, -1)
        }

        for (person in people) {
            var counter = person[1]
            var idx = 0
            while (counter >= 0) {
                if(result[idx][0] < person[0]) {
                } else {
                    counter--
                }

                idx++
            }

            result[idx - 1] = person
        }

        return result
    }
}