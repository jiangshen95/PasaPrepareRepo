class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def detectCycle(self, head: ListNode) -> ListNode:
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                break
        
        if not fast or not fast.next:
            return None

        slow = head
        while slow != fast:
            slow = slow.next
            fast = fast.next
        return slow

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
    res = solution.detectCycle(head)
    if res:
        print(res.val)
    else:
        print("no cycle")