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
    public int sumNumbers(TreeNode root) {
        List<Integer> nums = new LinkedList<>();
        dfs(root, 0, nums);
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        return sum;
    }

    private void dfs(TreeNode root, int num, List<Integer> nums) {
        if (root == null) return;
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            nums.add(num);
        }
        dfs(root.left, num, nums);
        dfs(root.right, num, nums);
    }
}