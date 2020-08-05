class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        slow, fast = head, head
        pre = None
        while fast and fast.next:
            fast = fast.next.next
            t = slow.next
            slow.next = pre
            pre = slow
            slow = t
        if fast:
            slow = slow.next

        while pre and slow:
            if pre.val != slow.val:
                return False
            pre, slow = pre.next, slow.next
        return True

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    head = ListNode()
    cur = head
    for num in nums:
        cur.next = ListNode(num)
        cur = cur.next
    head = head.next

    solution = Solution()
    print(solution.isPalindrome(head))