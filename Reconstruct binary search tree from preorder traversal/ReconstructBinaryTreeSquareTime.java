class Node {
    int data;
    Node left, right;

    Node (int d) {
        data = d;
        left = right = null;
    }
}

class Index {
    int index = 0;
}

class ReconstructBinaryTreeSquareTime {
    Index index = new Index();

    /**
     * A recursive function to construct Full from pre[].
     * preIndex is used to keep track of index in pre[]. 
     */

    Node constructTreeUtil(int pre[], Index preIndex, int low, int high, int size) {
        //base case
        if (preIndex.index >= size || low > high) {
            return null;
        }

        //The first Node in preorder traversal is root, So take 
        // the node at preIndex from pre[] and make it root, 
        // and Increment preIndex
        Node root = new Node(pre[preIndex.index]);
        preIndex.index += 1;
        

        // if the current subarray has only one element, no need to recur
        if (low == high) {
            return root;
        }

        //Search the first element greater than root
        int i;
        for (i = low; i < high; i++) {
            if (pre[i] > root.data) {
                break;
            }
        }

        root.left = constructTreeUtil(pre, preIndex, preIndex.index, i-1, size);
        root.right = constructTreeUtil(pre, preIndex, i, high, size);
        
        return root;
    }

    Node constructTree(int pre[], int size) {
        return constructTreeUtil(pre, index, 0, size-1, size);
    }

    void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void main(String[] args) {
        ReconstructBinaryTreeSquareTime tree = new ReconstructBinaryTreeSquareTime();
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        Node root = tree.constructTree(pre, size);
        tree.printInorder(root);
    }
}