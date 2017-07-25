import java.util.*;

import javax.management.ListenerNotFoundException;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        if (head == null) return null;
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int num = stack.pop();
        int val = (num + 1) % 10;
        int carry = (num + 1) / 10;
        ListNode cur = new ListNode(val);
        while (!stack.empty() || carry != 0) {
            num = stack.empty() ? 0 :stack.pop();
            val = (num + carry) % 10;
            carry = (num + carry) / 10;
            ListNode temp = new ListNode(val);
            temp.next = cur;
            cur = temp;
        }
        return cur;
    }
}