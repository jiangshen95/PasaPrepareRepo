class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        def getNodesNum(root):
            if not root:
                return 0
            return 1 + getNodesNum(root.left) + getNodesNum(root.right)
        leftNum = getNodesNum(root.left)
        if leftNum + 1 == k:
            return root.val
        elif leftNum + 1 < k:
            return self.kthSmallest(root.right, k - leftNum - 1)
        else:
            return self.kthSmallest(root.left, k)

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    k = int(input())
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
    print(solution.kthSmallest(root, k))