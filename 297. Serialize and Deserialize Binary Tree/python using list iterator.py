class Codec:
    def serialize(self, root):
        def doit(node);
            if node:
                vals.append(str(node.val))
                doit(node.left)
                doit(node.right)
            else:
                vals.append('X')
        vals = []
        doit(root)
        return ' '.join(vals)
    def deserialize(self, data):
        def doit():
            val = next(vals)
            if val == 'X':
                return None
            node = TreeNode(int(val))
            node.left = doit()
            node.right = doit()
            return node
        vals = iter(data.split())
        return doit()
