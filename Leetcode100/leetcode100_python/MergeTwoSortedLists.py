class ListNode:
    def __init__(self, val = 0, next = None):
        self.val = val
        self.next = next

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if not l1:
            return l2
        if not l2:
            return l1
        if l1.val < l2.val:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l1, l2.next)
            return l2


if __name__ == "__main__":
    nums1 = [int(num) for num in input().split()]
    nums2 = [int(num) for num in input().split()]

    l1 = ListNode()
    l2 = ListNode()

    p = l1
    for num in nums1:
        p.next = ListNode(num)
        p = p.next
    
    p = l2
    for num in nums2:
        p.next = ListNode(num)
        p = p.next

    l1 = l1.next
    l2 = l2.next
    
    solution = Solution()
    result = solution.mergeTwoLists(l1, l2)
    while result:
        print(result.val, " ")
        result = result.next