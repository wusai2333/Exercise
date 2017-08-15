public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, root, k);
    }

    private boolean dfs(TreeNode root, TreeNode cur, int k) {
        if (cur == null) return false;
        return search(root, cur, k - cur.val) || search(root, cur.left, k) || search(root, cur.right, k);
    }

    private boolean search(TreeNode root, TreeNode cur, int value) {
        if (root == null) return false;
        return (root.val == value) && (root != cur) || (root.val < value) && search(root.right, cur, value)
                || (root.val > value) && search(root.left, cur, value);
    }
}