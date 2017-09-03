public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String spreorder = generatePreorderString(s);
        String tpreorder = generatePreorderString(t);

        return kmp(spreorder, tpreorder);
    }

    private String generatePreorderString(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                sb.append("#");
            }
            else {
                sb.append(node.val);
                stack.push(node.left);
                stack.push(node.right);
            }
        }
        return sb.toString();
    }
}