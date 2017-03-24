# Definition for singly-linked list with a random pointer.
# class RandomListNode(object):
#     def __init__(self, x):
#         self.label = x
#         self.next = None
#         self.random = None

class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """
        if head == None: return None
        dic = collections.defaultdict()
        # loop 1: copy all the nodes
        node = head
        while node != None:
            dic[node] = RandomListNode(node.label)
            node = node.next
        # loop 2: assign next and random pointers
        node = head
        while node != None:
            if node.next != None:
                dic[node].next = dic[node.next]
            else:
                dic[node].next = None
            if node.random != None:
                dic[node].random = dic[node.random]
            else:
                dic[node].random = None
            node = node.next
            
        return dic[head]