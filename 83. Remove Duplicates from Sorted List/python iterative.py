# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        curr = head
        while curr != None:
            if curr.next == None:
                break
            if curr.val == curr.next.val:
                curr.next = curr.next.next
            else: 
                curr = curr.next
        return head