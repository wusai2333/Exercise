import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode p = head;
        int size = 0;
        while (p != null) {
            p = p.next;
            size ++;
        }
        k = (k >= size)? k % size: k;
        Stack<ListNode> stack = new Stack<>();
        p = new ListNode (0);
        p.next = head;
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        while ( k > 0) {
            ListNode node = stack.pop();
            node.next = p.next;
            p.next = node;
            k --;
        }
        stack.peek().next = null;
        return p.next;

    }
}