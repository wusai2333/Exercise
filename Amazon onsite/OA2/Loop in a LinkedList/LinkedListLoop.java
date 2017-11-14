class ListNode {
    int val; 
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
public class LinkedListLoop {
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head, slow = head, entry = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode (1);
        head.next.next = new ListNode(2);
        head.next.next.next = head.next;
        System.out.print(LinkedListLoop.hasCycle(head)+",");
        System.out.print(LinkedListLoop.detectCycle(head).val);
    }
}