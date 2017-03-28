<<<<<<< HEAD
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
=======
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
>>>>>>> eb4f20642d79ed3df07dab1830859263475bf5e5
