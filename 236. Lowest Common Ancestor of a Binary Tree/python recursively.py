class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        if root in (None, p, q): return root
        left, right = (self.lowestCommonAncestor(kid, p, q)
                        for kid in (root.left, root.right))
        return root if right and left else left or right
