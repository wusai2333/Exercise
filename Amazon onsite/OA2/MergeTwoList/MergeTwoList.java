class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) {
        val = x;
    }
}
public class MergeTwoList {
    public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode head = new ListNode (0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = (l1 == null) ? l2 : l1;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode cur = l1;
        for (int i = 0 ; i < 6; i++) {
            cur.next = new ListNode(i+3);
            cur = cur.next;
        }

        ListNode l2 = new ListNode(1);
        ListNode cur2 = l2;
        for (int i = 1; i < 6; i++) {
            cur2.next = new ListNode(2*i);
            cur2 = cur2.next; 
        }
        ListNode result = MergeTwoList.mergeTwoList(l1, l2);
        while (result != null) {
            System.out.print(result.val+" ");
            result = result.next;
        }
    }
}