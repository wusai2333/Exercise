<<<<<<< HEAD
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        return self.dfsHeight(root) != -1
        
    def dfsHeight(self, root):
        if root == None: return 0 
        leftHeight = self.dfsHeight(root.left)
        if leftHeight == - 1: return -1
        rightHeight = self.dfsHeight(root.right)
        if rightHeight == -1: return -1
        
        if abs(rightHeight - leftHeight) > 1: return -1
        return max(leftHeight , rightHeight) + 1
=======
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        return self.dfsHeight(root) != -1
        
    def dfsHeight(self, root):
        if root == None: return 0 
        leftHeight = self.dfsHeight(root.left)
        if leftHeight == - 1: return -1
        rightHeight = self.dfsHeight(root.right)
        if rightHeight == -1: return -1
        
        if abs(rightHeight - leftHeight) > 1: return -1
        return max(leftHeight , rightHeight) + 1
>>>>>>> eb4f20642d79ed3df07dab1830859263475bf5e5
        