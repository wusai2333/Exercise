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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        TreeNode root = buildTree(nums, 0, nums.length - 1);
        return root;
    }
    
    public TreeNode buildTree(int[] nums, int i, int j) {
        int index = getMax(nums, i, j);
        if (index == -1) return null;
        TreeNode root = new TreeNode(nums[index]);
        root.left = buildTree(nums, i, index - 1);
        root.right = buildTree(nums, index + 1, j);
        return root;
    }
    
    public int getMax(int[] nums, int i, int j) {
        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int p = i; p <= j; p++) {
            if (nums[p] > max) {
                index = p;
                max = nums[p];
            }
        }
        return index;
    }
}