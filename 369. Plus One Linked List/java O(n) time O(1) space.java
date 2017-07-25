public class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy, j = dummy;
        while(j.next != null) {
            j = j.next;
            if (j.val != 9) {
                i = j;
            }
        }
        // i is the first number that is smaller than 9 before a list of 9 in the end of the list
        // j is pointing the last node now.
        if (j.val != 9) {
            j.val ++;
        } else {
            i.val ++;
            i = i.next;
            while(i != null) {
                i.val = 0;
                i = i.next;
            }
        }

        if (dummy.val == 0) {
            return dummy.next;
        }
        return dummy;

    }
}