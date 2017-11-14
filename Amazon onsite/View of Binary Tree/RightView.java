class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        preorder(root, res, 1);
        return res;
    }

    private void preorder(TreeNode root, List<Integer> result, int level) {
        if (root == null) return;
        if (result.size() < level) result.add(root.val);
        preorder(root.right, result, level+ 1);
        preorder(root.left, result, level + 1);
    }

    // level order
    p
}