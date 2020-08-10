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
            return "#,"
        left = self.serialize(root.left)
        right = self.serialize(root.right)
        return str(root.val) + "," + left + right

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        def deserialize(nodes):
            if not nodes or nodes[0] == '#':
                nodes.pop(0)
                return None
            root = TreeNode(int(nodes[0]))
            nodes.pop(0)
            root.left = deserialize(nodes)
            root.right = deserialize(nodes)
            return root

        nodes = data.split(",")
        nodes.pop()
        return deserialize(nodes)

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