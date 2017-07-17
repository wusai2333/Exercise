class Solution(object):
    def rightSideView(self, root):
        if not root: return []
        ans = []
        self.rightView(root, ans, 0)
        return ans
    
    def rightView(self, root, ans, level):
        if not root: return
        if level == len(ans):
            ans.append(root.val)
        self.rightView(root.right, ans, level+1)
        self.rightView(root.left, ans, level+1)
