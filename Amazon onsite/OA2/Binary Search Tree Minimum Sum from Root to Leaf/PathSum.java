class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int x) {
        val = x;
    }
}
public class PathSum {
    public static int Solution(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null && root.right == null)
            return Solution(root.left) + root.val;
        if (root.right != null && root.left == null) 
            return Solution(root.right) + root.val;
        return Math.min(Solution(root.right), Solution(root.left)) + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(0);
        System.out.print(PathSum.Solution(root));
    }
}