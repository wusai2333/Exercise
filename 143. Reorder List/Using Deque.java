import java.util.*;

public class Solution {
    public void reorderList(ListNode head) {    
       if(head==null || head.next==null) return ;
        
        Deque<Integer> stk = new LinkedList<>();
        ListNode fast = head;
        ListNode slow = head;
        
        slow = slow.next;
        while(slow!=null){
            stk.addFirst(slow.val);
            slow=slow.next;
        }
        
        slow=head;
        
        while(!stk.isEmpty()){
                slow.next = new ListNode(stk.pollFirst());
                slow = slow.next;
            if( !stk.isEmpty()){
                slow.next = new ListNode(stk.pollLast());
                slow = slow.next;
            }
        }
    }
}