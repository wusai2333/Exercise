public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        int carry = 0;
        ListNode root = new ListNode(0);
        ListNode node = root;
        while (l1 != null|| l2 != null|| carry != 0) {
            int v1 = 0, v2 = 0;
            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }
            int val = (v1 + v2 + carry) % 10;
            carry = (v1 + v2 + carry) / 10;
            node.next = new ListNode(val);
            node = node.next;
        }
        return root;
    }
}