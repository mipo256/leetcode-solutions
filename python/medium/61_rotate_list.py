from typing import (Optional)

# Definition for singly-linked list.

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        size, end = self.getSize(head)

        if size == 0 or size == 1:
            return head

        steps = k % size
        startTravel = size - steps
        current = head

        for i in range(0, startTravel - 1):
            current = current.next
        toReturn = current.next
        current.next = None
        end.next = head
        return toReturn
    
    def getSize(self, start: Optional[ListNode]) -> int: 
        size = 0
        end = start
        while start is not None:
            size += 1
            end = start
            start = start.next
        return size, end
    
Solution().rotateRight(
    head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5, None))))), 
    k = 17
)