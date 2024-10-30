# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        if head.next == None: return None

        dummy = ListNode(0)
        dummy.next = head
        slow = fast = dummy

        while n and fast.next!= None:
            fast = fast.next
            n -= 1
        
        while fast.next != None:
            slow, fast = slow.next, fast.next

        slow.next = slow.next.next

        return dummy.next
        



        