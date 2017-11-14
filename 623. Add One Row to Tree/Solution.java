/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // 1. recursive DFS
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode n = new TreeNode(v);
            n.left = root;
            return n;
        }
        insert(v, root, 1, d);
        return root;
    }

    private void insert(int val, TreeNode node, int depth, int n) {
        if (node == null) {
            return;
        }
        if (depth == n - 1) {
            TreeNode t = node.left;
            node.left = new TreeNode(val);
            node.left.left = t;
            t = node.right;
            node.right = new TreeNode(val);
            node.right.right = t;
        } else {
            insert(val, node.left, depth+1, n);
            insert(val, node.right, depth+1, n);
        }
    }

    class Node {
        TreeNode node;
        int depth;
        Node(TreeNode n, int d) {
            node = n;
            depth = d;
        }
    }
    // 2. Stack DFS
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode n = new TreeNode(v);
            n.left = root;
            return n;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(new Node(root, 1));
        while (!stack.empty()) {
            Node n = stack.pop();
            if (n.depth == d - 1) {
                TreeNode t = n.node.left;
                n.node.left = new TreeNode(v);
                n.node.left.left = t;
                t = n.node.right;
                n.node.right = new TreeNode(v);
                n.node.right.right =t;
            } else {
                if (n.node.left != null) stack.push(new Node(n.node.left, n.depth+1));
                if (n.node.right != null) stack.push(new Node(n.node.right, n.depth+1));
            }
        }
        return root;
    }


    // 3. queue BFS
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode n = new TreeNode(v);
            n.left = root;
            return n;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = queue.poll();
                if (depth == d - 1) {
                    TreeNode t = n.left;
                    n.left = new TreeNode(v);
                    n.left.left = t;
                    t = n.right;
                    n.right = new TreeNode(v);
                    n.right.right = t;
                } else {
                    if (n.left != null) queue.offer(n.left);
                    if (n.right != null) queue.offer(n.right);
                }
            }
            if (depth == d - 1) break;
            else depth ++;
        }
        return root;
    }
}