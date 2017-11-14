/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    // 1. trivial recursive;
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }
    
    private void postorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
        return;
    }

    // 2. Follow up iterative
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            list.add(0, node.val);
            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
        }

        return list;
    }

    // 3. Follow up up
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.empty()) {
            TreeNode current = stack.peek();
            if (prev == null || prev.left == current || prev.right == current) {
                if (current.left != null) 
                    stack.push(current.left);
                else if (current.right != null) {
                    stack.push(current.right);
                } else {
                    stack.pop();
                    list.add(current.val);
                }
            } else if (current.left == prev) {
                if (current.right != null) 
                    stack.push(current.right);
                else {
                    stack.pop();
                    list.add(current.val);
                }
            } else if (current.right == prev) {
                stack.pop();
                list.add(current.val);
            }
            
            prev = current;
        }
        return list;
    }
}