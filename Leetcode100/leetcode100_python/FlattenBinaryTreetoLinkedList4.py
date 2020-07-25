class TreeNode:
    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return
        pre = None
        stack = [root]

        while stack:
            cur = stack.pop()
            if pre:
                pre.right = cur
                pre.left = None
            if cur.right:
                stack.append(cur.right)
            if cur.left:
                stack.append(cur.left)
            pre = cur

def printTree(root):
    if not root:
        return
    print(root.val)
    printTree(root.right)

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
    solution.flatten(root)
    printTree(root)