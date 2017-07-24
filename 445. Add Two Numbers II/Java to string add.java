public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        while (l1 != null) {
            num1.append(String.valueOf(l1.val));
            l1 = l1.next;
        }
        while (l2 != null) {
            num2.append(String.valueOf(l2.val));
            l2 = l2.next;
        }
        int p1 = num1.length()-1;
        int p2 = num2.length()-1;
        int carry = 0;
        ListNode dummy = new ListNode(0);
        while (p1 >= 0 || p2 >= 0 || carry > 0) {
            int m = 0, n = 0;
            if(p1 >= 0) {
                n = Character.getNumericValue(num1.charAt(p1));
            }
            if (p2>=0) {
                m = Character.getNumericValue(num2.charAt(p2));
            }
            ListNode newNode = new ListNode((n+m+carry)%10);
            newNode.next = dummy.next;
            dummy.next = newNode;
            carry = (n+m+carry)/10;
            p1 --;
            p2 --;
        }
        return dummy.next;
    }
}