/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return traverse(root.val, root, targetSum);
    }

    private boolean traverse(int currentSum, TreeNode node, int targetSum) {
        if (currentSum == targetSum && (node.left == null && node.right == null)) {
            return true;
        }
        
        if (node.left != null) {
            if (traverse(currentSum + node.left.val, node.left, targetSum)) return true;
        }
        if (node.right != null) {
            if (traverse(currentSum + node.right.val, node.right, targetSum)) return true;
        }
        return false;
    }
}
