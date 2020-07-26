class TreeNode:
    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def maxPathSum(self, root: TreeNode) -> int:
        self.result = float('-inf')
        def helper(root):
            if not root:
                return 0
            left_max = max(helper(root.left), 0)
            right_max = max(helper(root.right), 0)
            self.result = max(self.result, left_max + root.val + right_max)
            return max(left_max, right_max) + root.val
        if not root:
            return 0
        helper(root)
        return self.result

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
    print(solution.maxPathSum(root))