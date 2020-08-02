class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        pre, cur = None, head
        while cur:
            temp = cur.next
            cur.next = pre
            pre = cur
            cur = temp
        return pre


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