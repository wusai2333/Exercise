def tree2str(self, t):
    if t == None: return ""
    stack = []
    visited = set()
    stack.append(t)
    s = ""
    while stack:
        t = stack[-1]
        if t in visited:
            s += ")"
            stack.pop()
        else:
            s += "(" + str(t.val)
            visited.add(t)
            if not t.left and t.right:
                s += "()"
            if t.right:
                stack.append(t.right)
            if t.left:
                stack.append(t.left)
    return s[1:-1]