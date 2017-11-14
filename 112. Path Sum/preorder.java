class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sums = new Stack<>();
        stack.push(root);
        sums.push(sum);
        while (!stack.empty() && root != null) {
            int value = sums.pop();
            TreeNode cur = stack.pop();
            if (cur.left == null && cur.right == null && value == cur.val)
                return true;
            if (cur.right != null) {
                stack.push(cur.right);
                sums.push(value - cur.val);
            }
            if (cur.left != null) {
                stack.push(cur.left);
                sums.push(value - cur.val);
            }

        }
        return false;
    }
}