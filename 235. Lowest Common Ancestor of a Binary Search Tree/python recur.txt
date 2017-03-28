<<<<<<< HEAD
# Definition for a binary tree node.
# class TreeNode(object)
#     def __init__(self, x)
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object)
    def lowestCommonAncestor(self, root, p, q)
        
        type root TreeNode
        type p TreeNode
        type q TreeNode
        rtype TreeNode
        
    #    if p.val  root.val  q.val
      #      return self.lowestCommonAncestor(root.right, p, q)
     #   if p.val  root.val  q.val
       
      #     return self.lowestCommonAncestor(root.left, p, q)
    #    return root
        next = p.val  root.val  q.val and root.right or p.val  root.val  q.val and root.left or None
=======
# Definition for a binary tree node.
# class TreeNode(object)
#     def __init__(self, x)
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object)
    def lowestCommonAncestor(self, root, p, q)
        
        type root TreeNode
        type p TreeNode
        type q TreeNode
        rtype TreeNode
        
    #    if p.val  root.val  q.val
      #      return self.lowestCommonAncestor(root.right, p, q)
     #   if p.val  root.val  q.val
       
      #     return self.lowestCommonAncestor(root.left, p, q)
    #    return root
        next = p.val  root.val  q.val and root.right or p.val  root.val  q.val and root.left or None
>>>>>>> eb4f20642d79ed3df07dab1830859263475bf5e5
        return self.lowestCommonAncestor(next, p, q) if next else root