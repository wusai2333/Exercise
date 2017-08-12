class TreeNode {
    int val;
    TreeNode left, right, parent;
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode nextGreatestNode(TreeNode t) {
        TreeNode temp = t; // next Greatest cannot be found, return itself.
        if (t.right != null) return getLeftMost(t.right);
        while (t != null && t.parent != null) {
            TreeNode parent = t.parent;
            if (parent.left == t) return parent;
            t = t.parent;
        }
        return temp;
    }

    private TreeNode getLeftMost(TreeNode t) {
        TreeNode p = t;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }
}

public class nextGreaterElementBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode (2);
        root.left.parent = root;
        root.right = new TreeNode(4);
        root.right.parent = root;
        Solution solution = new Solution();
        TreeNode t = solution.nextGreatestNode(root);
        System.out.println(t.val);
    }
}