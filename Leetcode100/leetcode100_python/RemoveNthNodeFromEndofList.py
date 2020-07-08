class ListNode:
    def __init__(self, val = 0, next = None):
        self.val = val
        self.next = next

class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        preHead = ListNode()
        preHead.next = head

        p = preHead
        for i in range(n + 1):
            p = p.next
        
        q = preHead
        while p:
            p = p.next
            q = q.next

        q.next = q.next.next
        return preHead.next

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    n = int(input())

    head = ListNode()
    p = head
    for num in nums:
        p.next = ListNode(num)
        p = p.next
    head = head.next

    solution = Solution()
    result = solution.removeNthFromEnd(head, n)
    while result:
        print(result.val, " ")
        result = result.next