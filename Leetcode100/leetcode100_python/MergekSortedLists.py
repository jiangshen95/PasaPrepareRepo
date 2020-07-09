from typing import List

class ListNode:
    def __init__(self, val = 0, next = None):
        self.val = val
        self.next = next

class Solution:
    def mergeTwoLists(self, l1, l2):
        head = ListNode()
        p = head
        while l1 and l2:
            if l1.val < l2.val:
                p.next = l1
                l1 = l1.next
            else:
                p.next = l2
                l2 = l2.next
            p = p.next
        p.next = l1 if l1 else l2
        return head.next
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        def merge(l, r):
            if l == r:
                return lists[l]
            if l > r:
                return None
            mid = (l + r) // 2
            return self.mergeTwoLists(merge(l, mid), merge(mid + 1, r))
        return merge(0, len(lists) - 1)

if __name__ == "__main__":
    inputs = []
    line = input()
    while line:
        inputs.append([int(num) for num in line.split()])
        line = input()
    
    lists = []
    for nums in inputs:
        l = ListNode()
        p = l
        for num in nums:
            p.next = ListNode(num)
            p = p.next
        lists.append(l.next)

    solution = Solution()
    result = solution.mergeKLists(lists)
    while result:
        print(result.val, " ")
        result = result.next