class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class PathSum{
    public static int minimumPathSum(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null && root.right == null) {
            return minimumPathSum(root.left) + root.val;
        }
        if (root.left == null && root.right != null) {
            return minimumPathSum(root.right) + root.val;
        }
        return Math.min(minimumPathSum(root.left), minimumPathSum(root.right)) + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.print(PathSum.minimumPathSum(root));
    }
}