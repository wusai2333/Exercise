/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) return head;
        int pos = 1;
        ListNode dummy = new ListNode(9);
        dummy.next = head;
        ListNode start = head, end, prev = dummy;
        while (head != null) {
            if (pos == m - 1) {
                prev = head;
            }
            if (pos == m) {
                start = head;
            }
            if (pos == n) {
                end = head;
                ListNode post = end.next;
                prev.next = reverse(start, end, post);
                start.next = post;
                break;
            }
            head = head.next;
            pos ++;
            
        }
        return dummy.next;
    }
    
    private ListNode reverse(ListNode start, ListNode end, ListNode post) {
        if (start == end) return start;
        ListNode prev = new ListNode(0);
        while (start != post) {
            ListNode next = start.next;
            start.next = prev.next;
            prev.next = start;
            start = next;
        }
        return prev.next;
    }
}