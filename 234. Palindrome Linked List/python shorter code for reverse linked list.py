# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        slow = fast = head
        rev = None
        while fast and fast.next:
            fast = fast.next.next
            rev, rev.next, slow = slow, rev, slow.next # reverse linked list with shorter code in python than C++ and java
        if fast:
            slow = slow.next
        while rev and slow:
            if rev.val != slow.val:
                return False
            rev = rev.next
            slow = slow.next
        return True
       
"""
. The swapping by , of Python is really powerful! rev, rev.next, slow = slow, rev, slow.next becomes the following 4 lines of codes in C++, much verbose :-)

ListNode* tmp = rev;
rev = slow;
slow = slow -> next;
rev -> next = tmp;
""" 