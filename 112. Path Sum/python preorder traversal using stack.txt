# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def hasPathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        """
        stack = []
        sums = []
        
        stack.append(root)
        sums.append(sum)
        while stack and root:
            value = sums.pop()
            top = stack.pop()
            if top.left == None and top.right == None and top.val == value:
                return True
            if top.right != None:
                stack.append(top.right)
                sums.append(value - top.val)
            if top.left != None:
                stack.append(top.left)
                sums.append(value - top.val)
            
        return False