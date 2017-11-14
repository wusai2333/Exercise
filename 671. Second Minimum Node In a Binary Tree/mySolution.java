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
    int first = Integer.MAX_VALUE;
    int second = Integer.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        dfs(root);
        return second == Integer.MAX_VALUE ? -1: second;
    }
    
    private void dfs(TreeNode node) {
        if (node == null) return;
        if (node.val >= second) return;
        if (node.val < first) {
            second = first;
            first = node.val;
        } else if (node.val != first && node.val < second) {
            second = node.val;
        }
        
        dfs(node.left);
        dfs(node.right);
    }
}