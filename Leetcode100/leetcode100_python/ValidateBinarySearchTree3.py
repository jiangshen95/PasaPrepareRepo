class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        if not root:
            return True
        cur = root
        pre = -(1 << 33)
        while cur:
            if not cur.left:
                if cur.val <= pre:
                    return False
                pre = cur.val
                cur = cur.right
            else:
                pre_node = cur.left
                while pre_node.right and pre_node.right != cur:
                    pre_node = pre_node.right
                
                if not pre_node.right:
                    pre_node.right = cur
                    cur = cur.left
                elif pre_node.right == cur:
                    if cur.val <= pre:
                        return False
                    pre = cur.val
                    print(cur.val)
                    pre_node.right = None
                    cur = cur.right
        return True

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
    print(solution.isValidBST(root))