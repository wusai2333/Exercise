public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode tail = head;
        int size = 1;
        while (tail.next != null) {
            tail = tail.next;
            size ++;
        }
        tail.next = head;
        // create a circle; then break it between the break point tail;
        k = k >= size ? k % size: k;
        for (int i = 0; i < size - k; i ++) {
            tail = tail.next;
        }
        ListNode newHead = tail.next;
        tail.next =null;
        return newHead;
    }
}