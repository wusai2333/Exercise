/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode re = reverse(head);
        while (re != null) {
            if (re.val != head.val) {
                return false;
            }
            re = re.next;
            head = head.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode cur = new ListNode(head.val);
            cur.next = dummy.next;
            dummy.next = cur;
            head = head.next;
        }
        return dummy.next;
    }
}