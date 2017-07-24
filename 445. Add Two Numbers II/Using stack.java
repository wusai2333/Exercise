import java.util.Stack;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode dummy = new ListNode(0);
        int carry = 0;
        while (!s1.empty() || !s2.empty() || carry > 0) {
            int n = 0, m = 0;
            if (!s1.empty()) {
                 n = s1.pop();
            }
            if (!s2.empty()) {
                m = s2.pop();
            }
            ListNode newNode = new ListNode((n+m+carry)%10);
            newNode.next = dummy.next;
            dummy.next = newNode;
            carry = (n + m + carry) / 10;
        }
        return dummy.next;
    }
}