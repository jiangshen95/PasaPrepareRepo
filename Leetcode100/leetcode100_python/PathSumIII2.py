class TreeNode:
    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> int:
        def dfs(root, sumList):
            if not root:
                return 0
            sumList = [num + root.val for num in sumList]
            sumList.append(root.val)
            return sumList.count(sum) + dfs(root.left, sumList) + dfs(root.right, sumList)
        return dfs(root, [])

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