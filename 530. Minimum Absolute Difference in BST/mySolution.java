/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int minDiff = Integer.MAX_VALUE;
    private Integer prevValue = null;
    public int getMinimumDifference(TreeNode root) {
        Integer prevValue = null;
        inorder(root);
        return minDiff;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prevValue != null) {
            minDiff = Math.min(minDiff, root.val - prevValue);
        }
        prevValue = root.val;
        inorder(root.right);
    }
}