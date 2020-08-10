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
            return ""
        queue = [root]
        result = ""
        while queue:
            cur = queue.pop(0)
            if not cur:
                result += "#,"
            else:
                result += str(cur.val) + ","
                queue.append(cur.left)
                queue.append(cur.right)
        return result

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if not data:
            return None
        nodes = data.split(",")
        root = TreeNode(int(nodes[0]))
        queue = [root]
        for i in range(1, len(nodes) - 1, 2):
            cur = queue.pop(0)
            if nodes[i] != "#":
                cur.left = TreeNode(int(nodes[i]))
                queue.append(cur.left)
            if nodes[i + 1] != "#":
                cur.right = TreeNode(int(nodes[i + 1]))
                queue.append(cur.right)

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