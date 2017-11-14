import java.util.Stack;
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}

class Index {
    int index = 0;
}

class ReconstructBinarySearchTree {
    Index index = new Index();

    // A recursive function to construct BST from pre[]. 
    // preIndex is used to keep back of index in pre[]
    Node constructTreeUtil(int[] pre, Index preIndex, int key, int min, int max, int size) {

        // Base case
        if (preIndex.index >= size) {
            return null;
        }

        Node root = null;

        //If current element of pre[] is in range, then
        // only it is part of current subtree
        if (key > min && key < max) {
            // Allocate memory for root of this subtree and increment *preIndex
            root = new Node(key);
            preIndex.index += 1;
            if (preIndex.index < size) {
                root.left = constructTreeUtil(pre, preIndex, pre[preIndex.index], min, key, size);
                root.right = constructTreeUtil(pre, preIndex, pre[preIndex.index], key, max, size);
            }
        }
        return root;
    }

    Node constructTree(int[] pre, int size) {
        return constructTreeUtil(pre, index, pre[0], Integer.MIN_VALUE, Integer.MAX_VALUE, size);
    }

    void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    Node constructTreeInteratively(int[] pre, int size) {
        // the first element of pre[] is always root
        Node root = new Node(pre[0]);
        Stack<Node> s = new Stack<>();
        //push root

        s.push(root);
        //Iterate through the rest of the size - 1 items of given preorder array.
        for (int i = 1; i < size; i++) {
            Node temp = null;
            
            // keep on popping while the next value is greater than stack's top value
            while (!s.empty() && pre[i] > s.peek().data) {
                temp = s.pop();
            }

            // make this greater value as the right child and push it to the stack
            if (temp != null) {
                temp.right = new Node(pre[i]);
                s.push(temp.right);
            }
            else {
                temp = s.peek();
                temp.left = new Node(pre[i]);
                s.push(temp.left);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        ReconstructBinarySearchTree tree = new ReconstructBinarySearchTree();
        int[] pre = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        Node root = tree.constructTree(pre, size);
        System.out.println("Inorder traversal of the binary search tree is ");
        tree.printInorder(root);
        root = tree.constructTreeInteratively(pre, size);
        System.out.println("\nReconstruct by iterative function");
        tree.printInorder(root);
    }
}