
import java.util.*

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        val queue: Queue<TreeNode> = ArrayDeque()
        queue.add(root)

        var findP = false
        var findQ = false

        val parentMap = mutableMapOf<TreeNode, TreeNode?>()

        parentMap[root!!] = null

        while (queue.isNotEmpty()) {
            val node = queue.poll()

            if (node.`val` == p!!.`val`) {
                findP = true
            }

            if (node.`val` == q!!.`val`) {
                findQ = true
            }

            if (findP && findQ) {
                break
            }

            if (node.left != null) {
                queue.add(node.left)
                parentMap[node.left!!] = node
            }

            if (node.right != null) {
                queue.add(node.right)
                parentMap[node.right!!] = node
            }
        }

        val parentSet = mutableSetOf<TreeNode>()

        var parent = p
        while (parent != null) {
            parentSet.add(parent)
            parent = parentMap[parent]
        }

        parent = q
        while (parent != null) {
            if (parentSet.contains(parent)) {
                return parent
            }

            parentSet.add(parent)
            parent = parentMap[parent]
        }

        return root
    }
}