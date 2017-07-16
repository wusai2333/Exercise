class Solution(object):
    def str2tree(self, s):
        """
        :type s: str
        :rtype: TreeNode
        """
        if not s:
            return None
        stack = []
        i = 0
        while i < len(s):
            c = s[i]
            if c == ')':
                stack.pop()
            elif c == '-' or ord(c) >= ord('0') and ord(c) <= ord('9'):
                while i+1 < len(s) and ord(s[i+1]) <= ord('9') and ord(s[i+1]) >= ord('0'):
                    i += 1
                cur = TreeNode(int(s[j: i+1]))
                if stack:
                    t = stack[-1]
                    if t.left:
                        t.right = cur
                    else:
                        t.left = cur
                stack.append(cur)
            i += 1
        return stack[-1] if stack else None