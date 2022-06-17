class Solution {
        fun minCameraCover(root: TreeNode?): Int {
        val (NOT_MONITERED, HAS_CAMERA, MONITERED) = listOf(0, 1, 2)
        var total = 0
        
        fun postOrder(node: TreeNode?): Int {
            if (node == null) return MONITERED
            val left = postOrder(node.left)
            val right = postOrder(node.right)
            if (left == NOT_MONITERED || right == NOT_MONITERED) {
                total++
                return HAS_CAMERA
            }
            if (left == MONITERED && right == MONITERED) {
                return NOT_MONITERED
            } else {
                return MONITERED
            }
        }
        
        if (postOrder(root) == NOT_MONITERED) {
            total++
        }
        return total
    }
    
}