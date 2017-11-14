public class Solution {
    public ListNode getIntersection(ListNode headA, ListNode headB) {
        int sizeA = 0, sizeB = 0;
        ListNode a = headA, b = headB;
        while (a != null) {
            a = a.next;
            sizeA++;
        }
        while (b != null) {
            b = b.next;

            sizeB++;
        }
        int diff = sizeA - sizeB;
        ListNode first = headA, second = headB;
        if (diff < 0) {
            first = headB;
            second = headA;
            diff = -diff;
        }
        while (diff > 0) {
            first = first.next;
            diff --;
        }
        while (first != null) {
            if (first == second) {
                return first;
            }
            first = first.next;
            second = second.next;
        }
        return null;
    }
}