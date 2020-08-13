class TreeNode:
    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        def getDepth(root):
            if not root:
                return (0, 0)
            l, l_dim = getDepth(root.left)
            r, r_dim = getDepth(root.right)
            dim = max(l + r, l_dim, r_dim)
            return (max(l, r) + 1, dim)
        return getDepth(root)[1]

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    root = TreeNode(nums[0])
    queue = [root]
    for i in range(1, len(nums), 2):
        cur = queue.pop(0)
        if nums[i] != -1:
            cur.left = TreeNode(nums[i])
            queue.append(cur.left)
        if nums[i + 1] != -1:
            cur.right = TreeNode(nums[i + 1])
            queue.append(cur.right)
    solution = Solution()
    print(solution.diameterOfBinaryTree(root))