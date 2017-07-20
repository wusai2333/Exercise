import java.util.Stack;

import javax.swing.tree.TreeNode;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}