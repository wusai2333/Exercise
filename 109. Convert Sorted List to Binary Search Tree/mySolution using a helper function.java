/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/** This solution is not O(n) but it is still accepted. But with a helper function, it doesn't change the original list*/
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return toBST(head, null);
    }

    public TreeNode toBST(ListNode start, ListNode end) {
        if (start == end) return null;
        ListNode slow = start, fast = start;
        while (fast != end && fast.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        ListNode newStart = slow.next;
        root.left = toBST(start, slow);
        root.right = toBST(newStart, end);
        return root;
    }
}