class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return "X"
        left = "(" + self.serialize(root.left) + ")"
        right = "(" + self.serialize(root.right) + ")"
        return left + str(root.val) + right

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if data == 'X':
            return None
        i = 0
        count = 0
        while i < len(data):
            if data[i] == '(':
                count += 1
            elif data[i] == ')':
                count -= 1
            if count == 0:
                break
            i += 1
        left = self.deserialize(data[1 : i])
        num_begin = i + 1
        i += 1
        while data[i] != "(":
            i += 1
        root = TreeNode(int(data[num_begin : i]))
        right = self.deserialize(data[i + 1: len(data) - 1])
        root.left, root.right = left, right
        return root

def printTree(root):
    if not root:
        return
    print(root.val)
    printTree(root.left)
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
    
    codec = Codec()
    data = codec.serialize(root)
    print(data)
    root = codec.deserialize(data)
    printTree(root)