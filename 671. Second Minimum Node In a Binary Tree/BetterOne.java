class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        int res = dfs(root, root.val);
        return res;
    }

    private int dfs(TreeNode root, int first) {
        if (root == null) return -1;
        if (root.val != first) return root.val;
        int left = dfs(root.left, first), right = dfs(root.right, first);

        if (left == -1) return right;
        if (right == -1) return left;
        return Math.min(right, left);
    }
}