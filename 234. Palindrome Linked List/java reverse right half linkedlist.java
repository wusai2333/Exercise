public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next !=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // reverse the second half;
        ListNode p = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = p;
            p = slow;
            slow = next;
        }
        // compare them
        while (p != null) {
            if (p.val != head.val) {
                return false;
            }
            p = p.next;
            head = head.next;
        }
        return true;
    }
}