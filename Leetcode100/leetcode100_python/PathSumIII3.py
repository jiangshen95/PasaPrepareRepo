class TreeNode:
    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> int:
        def dfs(root, cur_sum, prefix):
            if not root:
                return 0
            cur_sum += root.val
            count = prefix.get(cur_sum - sum, 0)
            prefix[cur_sum] = prefix.get(cur_sum, 0) + 1
            count += dfs(root.left, cur_sum, prefix) + dfs(root.right, cur_sum, prefix)
            prefix[cur_sum] -= 1
            return count
        prefix = {0: 1}
        return dfs(root, 0, prefix)

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    sum = int(input())
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
    print(solution.pathSum(root, sum))