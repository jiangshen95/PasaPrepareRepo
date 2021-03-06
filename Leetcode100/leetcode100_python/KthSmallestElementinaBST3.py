class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        cur = root
        count = 0
        while cur:
            if not cur.left:
                count += 1
                if count == k:
                    return cur.val
                cur = cur.right
            else:
                pre = cur.left
                while pre.right and pre.right != cur:
                    pre = pre.right
                if not pre.right:
                    pre.right = cur
                    cur = cur.left
                elif pre.right == cur:
                    pre.right = None
                    count += 1
                    if count == k:
                        return cur.val
                    cur = cur.right
        return 0

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