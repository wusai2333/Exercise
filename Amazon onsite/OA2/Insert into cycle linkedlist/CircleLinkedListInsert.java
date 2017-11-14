public class CircleLinkedListInsert {
    public static class CNode {
        int val;
        CNode next;
        CNode(int x) {
            val = x;
        }
    }
    public static CNode insert(CNode myList, int n) {
        // corner case if it is null
        if (myList == null) {
            CNode result = new CNode(n);
            result.next = result;
            return result;
        }
        CNode cur = myList;

        // case1 : cur.val <= n <= cur.next.val: insert between cur and cur.next;
        // case2 : x is the mimimum or maximum value in the list, insert between the maximum and minimum.
        // case3 : only one Node in the list, cur traverse back to the head: insert into the list.
        do {
            if (n >= cur.val && n <= cur.next.val) break;
            if (cur.val > cur.next.val && (n > cur.val || n < cur.next.val)) break;
            cur = cur.next; 
        } while (cur != myList);

        CNode newNode = new CNode(n);
        newNode.next = cur.next;
        cur.next = newNode;
        return newNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head;
        ListNode result = LinkedListInsert.solution(head, 1);
        ListNode cur = result;
        while (true) {
            System.out.print(cur.val + " ");
            cur = cur.next;
            if (cur == result) break;
        }
    }
}