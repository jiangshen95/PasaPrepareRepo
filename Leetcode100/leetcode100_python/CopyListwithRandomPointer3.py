class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random

class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return None
        cur = head
        while cur:
            temp = Node(cur.val)
            temp.next = cur.next
            cur.next = temp
            cur = temp.next

        cur = head
        while cur:
            if cur.random:
                cur.next.random = cur.random.next
            cur = cur.next.next

        cur = head
        new_head = head.next
        new_cur = head.next
        while cur:
            cur.next = cur.next.next
            if new_cur.next:
                new_cur.next = new_cur.next.next
            cur = cur.next
            new_cur = new_cur.next
        return new_head


if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    nodeList = []
    for i in range(0, len(nums), 2):
        nodeList.append(Node(nums[i]))

    for i in range(len(nodeList)):
        if i < len(nodeList) - 1:
            nodeList[i].next = nodeList[i + 1]
        if nums[i * 2 + 1] != -1:
            nodeList[i].random = nodeList[nums[i * 2 + 1]]
        
    solution = Solution()
    head = solution.copyRandomList(nodeList[0])
    while head:
        print(head.val)
        head = head.next