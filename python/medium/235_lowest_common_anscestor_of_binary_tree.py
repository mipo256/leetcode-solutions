# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        branch = self.direction(root.val, p.val, q.val)

        while root.val != p.val and root.val != q.val and branch is not None:
            if branch == -1:
                root = root.left
            else:
                root = root.right
            branch = self.direction(root.val, p.val, q.val)

        return root
    
    def direction(self, currentVal, first, second) -> bool:
        if first < currentVal and second < currentVal:
            return -1
        elif first > currentVal and second > currentVal:
            return 1
        else:
            return None