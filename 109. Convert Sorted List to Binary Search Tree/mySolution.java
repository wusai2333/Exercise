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
/** This solution is not O(n) but it is still accepted. */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode slow = head, fast = head, prev = head;
        while (fast != null && fast.next !=null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        ListNode newHead = slow.next;
        slow.next = null;
        prev.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(newHead);
        return root;
    }
}