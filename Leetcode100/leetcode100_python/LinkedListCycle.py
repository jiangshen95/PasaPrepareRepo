class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def hasCycle(self, head: ListNode) -> bool:
        if not head:
            return False
        slow, fast = head, head.next
        while fast and slow != fast:
            if not fast.next:
                return False
            slow = slow.next
            fast = fast.next.next
        return slow == fast

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    pos = int(input())
    head = ListNode(0)
    cur = head
    for num in nums:
        cur.next = ListNode(num)
        cur = cur.next
    
    head = head.next
    if pos != -1:
        p = head
        for i in range(pos):
            p = p.next
        cur.next = p
    solution = Solution()
    print(solution.hasCycle(head))