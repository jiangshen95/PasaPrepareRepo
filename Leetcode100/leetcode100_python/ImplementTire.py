class Trie:

    class TrieNode:
        def __init__(self, val):
            self.val = val
            self.nexts = {}
            self.isWord = False

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = self.TrieNode(" ")
        

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        cur = self.root
        for ch in word:
            if ch not in cur.nexts:
                cur.nexts[ch] = self.TrieNode(ch)
            cur = cur.nexts[ch]
        cur.isWord = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        cur = self.root
        for ch in word:
            if ch not in cur.nexts:
                return False
            cur = cur.nexts[ch]
        return cur.isWord
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        cur = self.root
        for ch in prefix:
            if ch not in cur.nexts:
                return False
            cur = cur.nexts[ch]
        return True