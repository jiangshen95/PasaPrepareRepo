class DLinkedNode:
    def __init__(self, key = 0, value = 0):
        self.key = key
        self.value = value
        self.next = None
        self.pre = None

class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.size = 0
        self.map = {}
        self.head = DLinkedNode()
        self.tail = DLinkedNode()
        self.head.next = self.tail
        self.tail.pre = self.head

    def get(self, key: int) -> int:
        if key not in self.map:
            return -1
        node = self.map[key]
        self.moveToHead(node)
        return node.value

    def put(self, key: int, value: int) -> None:
        if key in self.map:
            node = self.map[key]
            node.value = value
            self.moveToHead(node)
        else:
            node = DLinkedNode(key, value)
            self.addToHead(node)
            self.map[key] = node
            self.size += 1
            if self.size > self.capacity:
                self.map.pop(self.removeTail().key)
                self.size -= 1

    def removeNode(self, node):
        node.next.pre = node.pre
        node.pre.next = node.next
    
    def addToHead(self, node):
        node.next = self.head.next
        self.head.next.pre = node
        self.head.next = node
        node.pre = self.head

    def moveToHead(self, node):
        self.removeNode(node)
        self.addToHead(node)

    def removeTail(self):
        node = self.tail.pre
        self.removeNode(node)
        return node