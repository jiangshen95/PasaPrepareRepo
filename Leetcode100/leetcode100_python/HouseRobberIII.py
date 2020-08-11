class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def rob(self, root: TreeNode) -> int:
        def dfs(root):
            if not root:
                return 0
            if root in memo:
                return memo[root]
            money1 = dfs(root.left) + dfs(root.right)
            money2 = root.val
            if root.left:
                money2 += dfs(root.left.left) + dfs(root.left.right)
            if root.right:
                money2 += dfs(root.right.left) + dfs(root.right.right)
            memo[root] = max(money1, money2)
            return memo[root]

        memo = {}
        return dfs(root)

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
    print(solution.rob(root))