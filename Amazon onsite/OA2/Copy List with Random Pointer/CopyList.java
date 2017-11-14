import java.util.*;
class RandomListNode {
    int val;
    RandomListNode next;
    RandomListNode random;
    RandomListNode (int x) {
        val = x;
    }
}
public class CopyList {
    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        while (cur != null) {
            map.put(cur, new RandomListNode(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.next != null) {
                map.get(cur).next = map.get(cur.next);
            }
            if (cur.random != null) {
                map.get(cur).random = map.get(cur.random);
            }
            cur = cur.next;
        }
        return map.get(head);
    }

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(0);
        head.next = new RandomListNode(2);
        head.next.random = head;
        head.random = head;
        RandomListNode copy = CopyList.copyRandomList(head);
        while (copy != null) {
            System.out.print(copy.val+ ",");
            System.out.print(copy.random.val+ " ");
            copy = copy.next;
        }
        System.out.println();
        System.out.println(copy == head);
    }
}