import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javafx.scene.chart.StackedBarChart;

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
        int len = nums.length;
        TreeNode head = new TreeNode(0); // place a holder.
        Stack<Integer> leftIndexStack = new Stack<Integer>();
        Stack<Integer> rightIndexStack = new Stack<Integer>();
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(head);
        leftIndexStack.push(0);
        rightIndexStack.push(len-1);

        while(!nodeStack.empty()) {
            TreeNode curNode = nodeStack.pop();
            int left = leftIndexStack.pop();
            int right = rightIndexStack.pop();
            int mid = left + (right - left)/2;
            curNode.val = nums[mid];

            if (left <= mid-1) {
                curNode.left = new TreeNode(0);
                nodeStack.push(curNode.left);
                leftIndexStack.push(left);
                rightIndexStack.push(mid-1);
            }
            if (mid + 1 <= right) {
                curNode.right = new TreeNode(0);
                nodeStack.push(curNode.right);
                leftIndexStack.push(mid+1);
                rightIndexStack.push(right);
            }
        }
        return head;
    }
}