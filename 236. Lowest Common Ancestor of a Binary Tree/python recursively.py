<<<<<<< HEAD
class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        if root in (None, p, q): return root
        left, right = (self.lowestCommonAncestor(kid, p, q)
                        for kid in (root.left, root.right))
        return root if right and left else left or right
=======
class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        if root in (None, p, q): return root
        left, right = (self.lowestCommonAncestor(kid, p, q)
                        for kid in (root.left, root.right))
        return root if right and left else left or right
>>>>>>> eb4f20642d79ed3df07dab1830859263475bf5e5
