class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if not head: return None
        cur = head
        while head.next:
            temp = head.next.next
            head.next.next = cur
            cur = head.next
            head.next = temp
        return cur


if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    head = ListNode()
    cur = head
    for num in nums:
        cur.next = ListNode(num)
        cur = cur.next
    head = head.next

    solution = Solution()
    cur = solution.reverseList(head)
    while cur:
        print(cur.val)
        cur = cur.next