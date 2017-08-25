class Solution {
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (root.val >= p.val) {
            return inorderPredecessor(root.left, p);
        } else {
            TreeNode right = inorderPredecessor(root.right , p);
            return right != null ? right : root;
        }
    }
}