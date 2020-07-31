class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if not headA or not headB:
            return None
        pA, pB = headA, headB
        while pA != pB:
            pA = pA.next if pA else headB
            pB = pB.next if pB else headA
        return pA

if __name__ == "__main__":
    nums1 = [int(num) for num in input().split()]
    nums2 = [int(num) for num in input().split()]
    skipA = int(input())
    skipB = int(input())

    headA = ListNode()
    cur = headA
    for num in nums1:
        cur.next = ListNode(num)
        cur = cur.next
    headA = headA.next

    cur = headA
    for i in range(skipA):
        cur = cur.next

    headB = ListNode()
    p = headB
    for i in range(skipB):
        p.next = ListNode(nums2[i])
        p = p.next
    p.next = cur
    headB = headB.next

    solution = Solution()
    result = solution.getIntersectionNode(headA, headB)
    print(result.val)