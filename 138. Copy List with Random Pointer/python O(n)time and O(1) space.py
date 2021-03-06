An intuitive solution is to keep a hash table for each node in the list, via which we just need to iterate the list in 2 rounds respectively to create nodes and assign the values for their random pointers. As a result, the space complexity of this solution is O(N), although with a linear time complexity.

As an optimised solution, we could reduce the space complexity into constant. The idea is to associate the original node with its copy node in a single linked list. In this way, we don't need extra space to keep track of the new nodes.

The algorithm is composed of the follow three steps which are also 3 iteration rounds.

1.Iterate the original list and duplicate each node. The duplicate
of each node follows its original immediately.
2.Iterate the new list and assign the random pointer for each
duplicated node.
3.Restore the original list and extract the duplicated nodes.

The algorithm is implemented as follows:

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
        iter = head
        # first round: make copy of each node
        # and link them together side-by-side in a single list
        while iter != None:
            next = iter.next
            copy = RandomListNode(iter.label)
            iter.next = copy
            copy.next = next
            iter = next
        
        # second round: assign random pointer for the copy nodes
        iter = head
        while iter != None:
            if iter.random != None:
                iter.next.random = iter.random.next
            iter = iter.next.next
            
        # Third round: restore the original list and extract the copy list
        iter = head
        pseudoHead = RandomListNode(0)
        copyIter = pseudoHead
        
        while iter != None:
            next = iter.next.next
            
            #extract the copy
            copy = iter.next
            copyIter.next = copy
            copyIter = copy
            
            # restore the original list
            iter.next = next
            iter = next
        
        return pseudoHead.next
