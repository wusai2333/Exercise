/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head;
        ListNode h2 = head.next;
        while (p != null && p.next != null) {
            if (p.next.next == null) {
                p.next = null;
                break;
            }
            ListNode next = p.next;
            p.next = p.next.next;
            p = next;
        }
        p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = h2;
        return head;
    }
}