import java.util.HashMap;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // first loop copy all the node:
        if (head == null) return head;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = head;
        while (node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }

        // Second loop assign pointers:
        node = head;
        while (node != null) {
            if (node.next != null) {
                map.get(node).next = map.get(node.next);
            }
            if (node.random != null) {
                map.get(node).random = map.get(node.random);
            }
            node = node.next;
        }

        return map.get(head);
    }
}