/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/** This solution is right but it costs too much time, and it will get a time Limit exceed. */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode mergeList = new ListNode(0);
        for (int i = 0; i < lists.length; i++) {
            mergeList.next = merge(mergeList.next, lists[i]);
        }
        return mergeList.next;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null? l2: l1;
        }
        int x;
        if (l1.val > l2.val) {
            x = l2.val;
            l2 = l2.next;
        } else {
            x = l1.val;
            l1 = l1.next;
        }
        ListNode newList = new ListNode(x);
        newList.next = merge(l1, l2);
        return newList;
    }
}