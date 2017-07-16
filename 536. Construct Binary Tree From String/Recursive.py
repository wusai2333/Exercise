def str2tree(self, s):
    if s == "" or len(s) == 0:
        return ""
    firstParen = s.find("(")
    if firstParen == -1:
        return TreeNode(int(s))
    cur = TreeNode(int(s[:firstParen]))
    start, leftParenCount = firstParen, 0
    for i in range(start, len(s)):
        if s[i] == "(":
            leftParenCount += 1
        elif s[i] == ")":
            leftParenCount -= 1
        if leftParenCount == 0 and start == firstParen:
            cur.left = self.str2tree(s[start+1: i])
            start += 1
        elif leftParenCount == 0:
            cur.right = self.str2tree(s[start+1: i])
    return cur