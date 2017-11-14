class ListNode {
    int val;
    ListNode next;
    ListNode (int val) {
        this.val = val;
    }
}
public class LinkedListInsert {
    public static ListNode solution(ListNode head, int val) {
        if (head == null) {
            ListNode result = new ListNode(val);
            result.next = result;
            return result;
        }
        ListNode cur = head;

        while (true) {
            if (val <= cur.next.val && val >= cur.val) break;
            if (cur.val > cur.next.val && (val > cur.val || val < cur.next.val)) break;
            cur = cur.next;
            if (cur == head) break;
        }

        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        cur.next = newNode;
        return newNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head;
        ListNode result = LinkedListInsert.solution(head, 4);
        ListNode cur = result;
        while (true) {
            System.out.print(cur.val + " ");
            cur = cur.next;
            if (cur == result) break;
        }
    }
}