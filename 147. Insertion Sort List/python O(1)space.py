# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def insertionSortList(self, head):
        """
        :type head: ListNode  
        :rtype: ListNode
        """
        if not head: return head
        newHead = ListNode(0) # new starter of the sorted list
        cur = head  # the node will be inserted
        pre = newHead # insert node between pre and pre.next
        nxt = None # the next node will be inserted
        # not the end of the input list
        while cur:
            nxt = cur.next
            # find the right place to insert
            while pre.next and pre.next.val < cur.val:
                pre = pre.next
            # insert between pre and pre.next
            cur.next = pre.next
            pre.next = cur
            pre = newHead
            cur = nxt
            
        return newHead.next
        