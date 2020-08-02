class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head
        new_head = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        return new_head


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