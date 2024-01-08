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

    public int rangeSumBST(TreeNode root, int low, int high) {
        return this.rangeSum(root, low, high);
    }

    public int rangeSum(TreeNode root, int low, int high) {
        int sum = 0;
        if (root.val >= low && root.val <= high) {
            sum += root.val;
            if (root.val > low && root.left != null) {
                sum += this.rangeSum(root.left, low, high);
            }
            if (root.val < high && root.right != null) {
                sum += this.rangeSum(root.right, low, high);
            }
        }
        if (root.val > high) {
            if (root.left != null) {
                sum += this.rangeSum(root.left, low, high);
            }            
        }
        if (root.val < low) {
            if (root.right != null) {
                sum += this.rangeSum(root.right, low, high);
            }
        }
        return sum;
    }
}