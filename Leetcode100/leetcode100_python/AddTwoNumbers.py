class ListNode:
    def __init__(self, val = 0, next = None):
        self.val = val
        self.next = next

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        res = ListNode()
        p = res
        carry = 0
        while l1 or l2 or carry > 0:
            num = 0
            if l1:
                num += l1.val
                l1 = l1.next
            if l2:
                num += l2.val
                l2 = l2.next
            num += carry
            carry = 0
            if num >= 10:
                num -= 10
                carry = 1
            p.next = ListNode(num)
            p = p.next
        return res.next

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
    result = solution.addTwoNumbers(l1, l2)
    while result:
        print(result.val, " ")
        result = result.next