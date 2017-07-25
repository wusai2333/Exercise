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
    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0, root.val);
        return max;
    }
    private void dfs(TreeNode root, int cur,int target) {
        if (root == null) return;
        if (root.val == target) cur ++;
        else cur = 1;
        max = Math.max(cur, max);
        dfs(root.left, cur, root.val + 1);
        dfs(root.right, cur, root.val + 1);
    }
}