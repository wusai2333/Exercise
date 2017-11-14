class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) {
        val = x;
    }
}
public class ReverseSecondHalfOfLinkedList {
    public static ListNode reverseSecondHalfList (ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode prev = slow;
        System.out.println(slow.val);
        slow = slow.next;
        while (slow.next != null) {
            ListNode current = slow.next.next;
            slow.next.next = prev.next;
            prev.next = slow.next;
            slow.next = current;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode cur = l1;
        for (int i = 1 ; i <= 6; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode head = ReverseSecondHalfOfLinkedList.reverseSecondHalfList(l1);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}