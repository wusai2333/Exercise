import java.util.Stack;

import javax.swing.tree.TreeNode;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k --;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }
}