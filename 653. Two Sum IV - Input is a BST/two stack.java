class Solution {
    public boolean findTarget(TreeNode root, int target) {
        Stack<TreeNode> l_stack = new Stack<TreeNode>();
        Stack<TreeNode> r_stack = new Stack<TreeNode>();
        stackAdd(l_stack, root, true);
        stackAdd(r_stack, root, false);
        while (l_stack.peek() != r_stack) {
            int n = l_stack.peek().val + r_stack.peek().val;
            if (n == k) {
                return true;
            } else (n > k) {
                stackNext(r_stack, false);
            } else {
                stackNext(l_stack, true);
            }
        }
        return false;
    }

    private void stackNext(Stack<TreeNode> stack, boolean isLeft) {
        TreeNode n = stack.pop();
        if (isLeft) {
            stackAdd(stack, n.right, true);
        } else {
            stackAdd(stack, n.left, false);
        }
    }

    private void stackAdd(Stack<TreeNode> stack, TreeNode node, boolean isLeft) {
        while (node != null) {
            stack.push(node);
            node = (isLeft) ? node.left: node.right;
        }
    }
}