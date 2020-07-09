from typing import List

class ListNode:
    def __init__(self, val = 0, next = None):
        self.val = val
        self.next = next

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        import heapq
        heap = []
        for i, node in enumerate(lists):
            if node:
                heapq.heappush(heap, (node.val, i))
        
        head = ListNode()
        p = head

        while heap:
            cur_val, i = heapq.heappop(heap)
            p.next = lists[i]
            lists[i] = lists[i].next
            p = p.next
            if lists[i]:
                heapq.heappush(heap, (lists[i].val, i))
        return head.next

if __name__ == "__main__":
    inputs = []
    line = input()
    while line:
        inputs.append([int(num) for num in line.split()])
        line = input()
    
    lists = []
    for nums in inputs:
        l = ListNode()
        p = l
        for num in nums:
            p.next = ListNode(num)
            p = p.next
        lists.append(l.next)

    solution = Solution()
    result = solution.mergeKLists(lists)
    while result:
        print(result.val, " ")
        result = result.next