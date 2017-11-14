import java.util.HashMap;
import java.util.Map;
class Node {
    char data;
    Node left, right;
    Node(char d) {
        data = d;
        left = right = null;
    }
}

class BinaryTree {
    Node root;
    static int preIndex = 0;
    /**
     * Recuisive function to contruct binary tree of 
     * size len from Inorder traversal in[] and Preorder traversal pre[]
     * Initial values of inStart and inEnd should be 0 and len-1.
     * The function doesn't  do any error checking for cases where
     * inorder and preorder do not form a tree
     */
    Map<Character, Integer> map = new HashMap<>();
    BinaryTree(char[] in) {
        for(int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
    }

    Node buildTree(char[] in, char[] pre, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        // Pick current node from Preorder traversal
        // using preIndex and increment preIndex
        Node tNode = new Node(pre[preIndex++]);

        // If this Node has no children then return;
        if (inStart == inEnd) {
            return tNode;
        }
        // Else find the index of this node in inorder traversal
        int inIndex = map.get(tNode.data);
        // Using index in Inorder traversal, construct left and
        // right subtree
        tNode.left = buildTree(in, pre, inStart, inIndex-1);
        tNode.right = buildTree(in, pre, inIndex+1, inEnd);

        return tNode;
    }

    void printInorder(Node node) {
        if (node == null) return;

        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void main(String[] args) {
        char[] in = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char[] pre = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        BinaryTree tree = new BinaryTree(in);
        Node root = tree.buildTree(in, pre, 0, in.length-1);

        System.out.println("Inorder traversal of construct tree is:");
        tree.printInorder(root);
    }
}