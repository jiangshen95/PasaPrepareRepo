from typing import List

class TreeNode:
    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        def helper(preBegin, preEnd, inBegin, inEnd):
            if preBegin > preEnd:
                return None
            root = TreeNode(preorder[preBegin])
            index = inorder.index(preorder[preBegin])
            root.left = helper(preBegin + 1, preBegin + index - inBegin, inBegin, index - 1)
            root.right = helper(preBegin + index - inBegin + 1, preEnd, index + 1, inEnd)
            return root
        return helper(0, len(preorder) - 1, 0, len(inorder) - 1)

def printTree(root):
    if not root:
        return
    print(root.val)
    printTree(root.left)
    printTree(root.right)

if __name__ == "__main__":
    preorder = [int(num) for num in input().split()]
    inorder = [int(num) for num in input().split()]
    solution = Solution()
    root = solution.buildTree(preorder, inorder)
    printTree(root)