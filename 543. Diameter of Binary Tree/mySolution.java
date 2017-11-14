class Solution {
    Map<TreeNode, Integer> map = new HashMap<>();
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        return Math.max(path(root), Math.max(left, right));
    }

    private int path(TreeNode node) {
        return height(node.left) + height(node.right);
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int left = height(root.left);
        int right = height(root.right);
        int h = Math.max(left, right) + 1;
        map.put(root, h);
        return h;
    }
}