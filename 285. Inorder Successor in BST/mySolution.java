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
    TreeNode prev = null;
    TreeNode result = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorder(root, p);
        return result;
    }

    private void inorder(TreeNode root, TreeNode p) {
        if (root == null) return;
        inorder(root.left, p);
        if (prev != null && prev.val == p.val) {
            result = root;
            System.out.print(result.val);
        }
        prev = root;
        inorder(root.right, p);
    }
}