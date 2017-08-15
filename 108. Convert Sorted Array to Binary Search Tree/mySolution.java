import java.util.LinkedList;
import java.util.Queue;

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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        int start = 0, end = nums.length - 1;
        int mid = start + (end - start) /2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums,start, mid-1);
        root.right = buildBST(nums, mid+1, end);
        return root;
    }

    public TreeNode buildBST(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) /2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, start, mid - 1);
        root.right = buildBST(nums, mid + 1, end);
        return root;
    }
}