class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class TreeAmplitude {
    public static int diffOfMaxAndMin(TreeNode root) {
        if (root == null) return 0;
        return helper(root, root.val, root.val);
    }

    private static int helper(TreeNode root, int max, int min) {
        if (root == null) return max - min;
        if (root.val > max) max = root.val;
        if (root.val < min) min = root.val;
        return Math.max(helper(root.left, max, min), helper(root.right, max, min));
    }

    private static int tmp = 0;
    public static int getAmplitude(TreeNode root) {
        if (root == null) return 0;
        int result = dfs(root, root.val, root.val);
        return result;
    }

    private static int dfs(TreeNode root, int min, int max) {
        if (root == null) return 0;
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        if (root.left == null && root.right == null) {
            tmp = Math.max(max - min, tmp);
        }
        dfs(root.left, min, max);
        dfs(root.right, min, max);
        return tmp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-4);
        System.out.println(TreeAmplitude.diffOfMaxAndMin(root));
        System.out.print(TreeAmplitude.getAmplitude(root));
    }
}