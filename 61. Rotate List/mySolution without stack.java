public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            retuen head;
        }
        ListNode tail = head;
        int size = 0;
        while (tail != null) {
            tail = tail.next;
            size ++;
        }
        tail.next = head;
        k = k >= size ? k % size: k;
        for (int i = 0; i < size - k; i ++) {
            tail = tail.next;
        }
        ListNode newHead = tail.next;
        tail.next =null;
        return newHead;
    }
}