class Solution(object):
    def rightSideView(self, root):
        if not root: return []
        ans, level = [], [root]
        while level:
            ans.append(level[-1].val)
            level = [kid for node in level for kid in (node.left, node.right) if kid]
        return ans