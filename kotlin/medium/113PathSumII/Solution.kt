/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

import java.util.Stack

class Solution {
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        if (root == null) return listOf()

        val response = mutableListOf<List<Int>>()
        val chain = Stack<Int>()
        chain.push(root.`val`)

        traverse(root.`val`, root, targetSum, chain, response)
        return response
    }

    private fun traverse(
        currentSum: Int,
        currentNode: TreeNode,
        targetSum: Int,
        chain: Stack<Int>,
        paths: MutableList<List<Int>>
    ) {

        if (currentSum == targetSum && currentNode.isLeaf()) {
            paths.add(chain.toList())
            chain.pop()
            return
        }

        if (currentNode.left != null) {
            chain.push(currentNode.left.`val`)
            traverse(currentSum + currentNode.left!!.`val`, currentNode.left!!, targetSum, chain, paths)
        }
        if (currentNode.right != null) {
            chain.push(currentNode.right.`val`)
            traverse(currentSum + currentNode.right!!.`val`, currentNode.right!!, targetSum, chain, paths)
        }
        chain.pop()
    }
}

fun TreeNode.isLeaf() : Boolean = this.left == null && this.right == null
