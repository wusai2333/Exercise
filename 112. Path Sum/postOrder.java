class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null, cur = root;
        int SUM = 0;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.add(cur);
                SUM += cur.val;
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.left == null && cur.right == null && SUM == sum)
                return true;
            if (cur.right != null && pre != cur.right) {
                cur = cur.right;
            } else {
                pre = cur;
                stack.pop();
                SUM -= cur.val;
                cur = null;
            }
        }
        return false;
    }
}