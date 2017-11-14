class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode (int x) {
        val = x;
    }
}
public class SubTree {
    public static int isSubTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) return 1;
        if (t1 == null) return -1; 
        if (check(t1, t2)) return 1;
        int left = isSubTree(t1.left, t2);
        int right = isSubTree(t1.right, t2);
        if (left == 1 || right == 1) return 1;
        return -1;
    }

    private static boolean check(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        return check(t1.left, t2.left) && check(t1.right, t2.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        TreeNode t2 = new TreeNode (3);
        root.left.left = t2;
        t2.left = new TreeNode(4);
        t2.right = new TreeNode(5);
        System.out.print(SubTree.isSubTree(root, t2));
    }
}