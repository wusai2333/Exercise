
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        addTwoNumbers(root, l1, l2, 0);
        return root.next;
    }
    private void addTwoNumbers(ListNode root, ListNode l1, ListNode l2, int carry) {
        if (l1 != null && l2 != null) {
            root.next = new ListNode((l1.val + l2.val + carry)%10);
            addTwoNumbers(root.next, l1.next, l2.next, (l1.val + l2.val + carry)/10);
        }
        else if (l1 != null) {
            root.next = new ListNode((l1.val + carry)%10);
            addTwoNumbers(root.next, l1.next, l2, (l1.val + carry)/10);
        }
        else if (l2 != null) {
            root.next = new ListNode((l2.val + carry)%10);
            addTwoNumbers(root.next, l1, l2.next, (l2.val + carry)/10);
        }
        else if (carry != 0) {
            root.next = new ListNode(carry);
            addTwoNumbers(root.next, l1, l2, 0);
        }
    }
}