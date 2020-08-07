class TreeNode:
    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root or root.val == p.val or root.val == q.val:
            return root
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        if not left:
            return right
        if not right:
            return left
        return root


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