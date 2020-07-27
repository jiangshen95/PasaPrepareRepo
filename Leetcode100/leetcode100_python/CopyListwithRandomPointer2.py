class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random

class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        def getClonedNode(node):
            if not node:
                return None
            if node not in visited:
                visited[node] = Node(node.val)
            return visited[node]
        if not head:
            return None
        cur = head
        new_head = Node(head.val)
        p = new_head
        visited = {head : new_head}
        while cur:
            p.next = getClonedNode(cur.next)
            p.random = getClonedNode(cur.random)
            cur = cur.next
            p = p.next
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