import java.util.Stack;

import javax.swing.tree.TreeNode;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.empty()) {
            while(root != null) {
                stack.push(root);
                root= root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val) {
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }
}

/** If we use in-order traversal to serialize a binary search tree, we can
get a list of values in ascending order. It can be proved with the
definition of BST. And here I use the reference of TreeNode
pointer prev as a global variable to mark the address of previous node in the
list. */