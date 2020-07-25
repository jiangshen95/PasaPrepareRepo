from typing import List

class TreeNode:
    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder:
            return None
        root = TreeNode(preorder[0])
        stack = [root]
        cur = root
        inIndex = 0
        for i in range(1, len(preorder)):
            if(stack and inorder[inIndex] == stack[-1].val):
                while stack and inorder[inIndex] == stack[-1].val:
                    cur = stack.pop()
                    inIndex += 1
                cur.right = TreeNode(preorder[i])
                cur = cur.right
                stack.append(cur)
            else:
                cur.left = TreeNode(preorder[i])
                cur = cur.left
                stack.append(cur)
        return root


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