import java.util.*;
class TreeNode {
    int key;
    TreeNode left, right;
    public TreeNode (int key) {
        this.key = key;
        left = right = null;
    }
}

class QItem {
    TreeNode node;
    int hd;
    public QItem(TreeNode n, int h) {
        node = n;
        hd = h;
    }
}

class Tree {
    TreeNode root;
    public Tree() {root = null;}
    public Tree(TreeNode n) {
        root = n;
    }

    public List<Integer> topview() {
        // base case
        if (root == null) return new LinkedList<>();
        
        //Create an empty hashset
        HashSet<Integer> set = new HashSet<>();
        List<Integer> res = new LinkedList<>();
        // Create a queue and add root to it
        Queue<QItem> Q = new LinkedList<>();
        Q.add(new QItem(root, 0)); // Horizontal distance of root is 0

        // Standard BFS  or level order Traversal
        while (!Q.isEmpty()) {
            QItem qi = Q.poll();
            int hd = qi.hd;
            TreeNode n = qi.node;

            //If this is the first node at this horizontal distance
            // then it is in the top view.
            if (!set.contains(hd)) {
                set.add(hd);
                if (hd >= 0) res.add(n.key);
                else res.add(0, n.key);
            }
            // Enque the left and right
            if (n.left != null) Q.add(new QItem(n.left, hd-1));
            if (n.right != null) Q.add(new QItem(n.right, hd+1));
        }
        return res;
    }
}

public class Topview {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);
        Tree t = new Tree(root);
        List<Integer> res = t.topview();
        System.out.println("Following are nodes in top view of Binary Tree");
        for (int i = 0; i < res.size(); i++) {
            if (i < res.size() - 1) System.out.print(res.get(i) + ",");
            else System.out.print(res.get(i));
        }
    }
}