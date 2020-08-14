class TreeNode:
    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def mergeTrees(self, t1: TreeNode, t2: TreeNode) -> TreeNode:
        if not t1:
            return t2
        stack = [(t1, t2)]
        while stack:
            q1, q2 = stack.pop()
            if not q1 or not q2:
                continue
            q1.val += q2.val
            if not q1.left:
                q1.left = q2.left
            else:
                stack.append((q1.left, q2.left))
            if not q1.right:
                q1.right = q2.right
            else:
                stack.append((q1.right, q2.right))
        return t1

def initTree(nums):
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
    return root

def printTree(root):
    if not root:
        return
    print(root.val)
    printTree(root.left)
    printTree(root.right)

if __name__ == "__main__":
    nums1 = [int(num) for num in input().split()]
    nums2 = [int(num) for num in input().split()]
    solution = Solution()
    t1 = initTree(nums1)
    t2 = initTree(nums2)
    root = solution.mergeTrees(t1, t2)
    printTree(root)