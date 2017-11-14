public class SameTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    } 

    public static boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(0);
        t1.left = new TreeNode(1);
        t1.right = new TreeNode(2);
        TreeNode t2 = new TreeNode(0);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(2);
        t2.right.left = new TreeNode(0);
        System.out.print(SameTree.isSameTree(t1, t2));
    }
}