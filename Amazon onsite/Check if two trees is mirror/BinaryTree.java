class Node {
    int data;
    Node left, right;
    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTree {
    Node a, b;
    Node root;
    boolean areMirror(Node a, Node b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b== null) {
            return false;
        }
        if (a.data != b.data) return false;
        return areMirror(a.left, b.right) && areMirror(a.right, b.left);
    }

    boolean isSymmetric(Node root) {
        return isMirror(root, root);
    }

    boolean isMirror(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 != null && root2 != null && root2.data == root1.data) {
            return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
        }
        return false;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node a = new Node(1);
        Node b = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.left.left = new Node(4);
        a.left.right = new Node(5);
 
        b.left = new Node(3);
        b.right = new Node(2);
        b.right.left = new Node(5);
        b.right.right = new Node(4);
 
        if (tree.areMirror(a, b) == true)
            System.out.println("Yes");
        else
            System.out.println("No");

            
        tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(3);
        boolean output = tree.isSymmetric(tree.root);
        if (output == true)
            System.out.println("1");
        else
            System.out.println("0");
    }    
}