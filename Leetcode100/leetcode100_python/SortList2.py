class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head
        length = 0
        cur = head
        while cur:
            length += 1
            cur = cur.next
        
        dummy = ListNode()
        dummy.next = head

        step = 1
        while step < length:
            pre = dummy
            left = dummy.next
            while left:
                right = self.split(left, step)
                temp = self.split(right, step)
                pre = self.merge(left, right, pre)
                left = temp
            step <<= 1
        return dummy.next
                
    def split(self, cur, step):
        pre = cur
        for i in range(step):
            pre = cur
            if cur:
                cur = cur.next
        if pre:
            pre.next = None
        return cur

    def merge(self, l1: ListNode, l2: ListNode, cur: ListNode):
        while l1 and l2:
            if l1.val < l2.val:
                cur.next = l1
                l1 = l1.next
            else:
                cur.next = l2
                l2 = l2.next
            cur = cur.next
        cur.next = l1 if l1 else l2
        while cur.next: cur = cur.next
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
    cur = solution.sortList(head)
    while cur:
        print(cur.val)
        cur = cur.next