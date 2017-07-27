/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        int count = 0;
        while (head != null) {
            while (head != null && count < k) {
                count ++;
                head = head.next;
            }
            if (count < k) {
                break;
            }
            ListNode newPrev = prev.next;
            prev.next = reverse(prev.next, head);
            prev = newPrev;
            count = 0;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode start, ListNode end) {
        
        ListNode p = end;
        while (start != end) {
            System.out.println(start.val);
            ListNode cur = start;
            start = start.next;
            cur.next = p;
            p = cur;
        }
        return p;
    }
}