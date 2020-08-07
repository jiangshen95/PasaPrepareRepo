class TreeNode:
    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        parent = {root: None}
        queue = [root]
        while p not in parent or q not in parent:
            cur = queue.pop(0)
            if cur.left:
                parent[cur.left] = cur
                queue.append(cur.left)
            if cur.right:
                parent[cur.right] = cur
                queue.append(cur.right)
        
        ancestors = []
        while p:
            ancestors.append(p)
            p = parent[p]
        
        while q not in ancestors:
            q = parent[q]
        return q


if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    p = int(input())
    q = int(input())
    root = TreeNode(nums[0])
    queue = [root]

    pNode, qNode = None, None
    for i in range(1, len(nums), 2):
        cur = queue.pop(0)
        if cur.val == p:
            pNode = cur
        elif cur.val == q:
            qNode = cur
        if nums[i] != -1:
            cur.left = TreeNode(nums[i])
            queue.append(cur.left)
        if nums[i + 1] != -1:
            cur.right = TreeNode(nums[i + 1])
            queue.append(cur.right)
    
    while queue:
        cur = queue.pop(0)
        if cur.val == p:
            pNode = cur
        elif cur.val == q:
            qNode = cur
    solution = Solution()
    print(solution.lowestCommonAncestor(root, pNode, qNode).val)