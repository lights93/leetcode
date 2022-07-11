import java.util.*

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        val answer = mutableListOf<Int>()

        if(root == null) {
            return answer
        }
        val queue: Deque<TreeNode> = ArrayDeque<TreeNode>()

        queue.add(root)

        while (queue.isNotEmpty()) {
            val size = queue.size
            answer.add(queue.peekLast().`val`)

            for (i in 0 until size) {
                val node = queue.poll()
                if (node.left != null) {
                    queue.add(node.left)
                }
                if (node.right != null) {
                    queue.add(node.right)
                }
            }
        }

        return answer
    }
}