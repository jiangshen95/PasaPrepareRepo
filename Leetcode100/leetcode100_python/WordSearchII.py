from typing import List

class Solution:

    class TrieNode:
        def __init__(self):
            self.word = None
            self.children = {}

    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:

        def backtrack(i: int , j: int, parent: self.TrieNode) -> None:
            t = board[i][j]
            cur = parent.children[t]
            if cur.word:
                result.append(cur.word)
                cur.word = None
            board[i][j] = '#'
            dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]
            for x, y in dirs:
                row = i + x
                col = j + y
                if row >= 0 and row < m and col >= 0 and col < n and \
                    board[row][col] in cur.children:
                    backtrack(row, col, cur)
            board[i][j] = t
            if not cur.children:
                parent.children.pop(t)


        root = self.TrieNode()
        for word in words:
            cur = root
            for c in word:
                if c not in cur.children:
                    cur.children[c] = self.TrieNode()
                cur = cur.children[c]
            cur.word = word

        result = []
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                if board[i][j] in root.children:
                    backtrack(i, j, root)
        return result

if __name__ == "__main__":
    n = int(input())
    board = []
    for i in range(n):
        board.append([c for c in input().split()])
    
    n = int(input())
    words = []
    for i in range(n):
        words.append(input())
    
    solution = Solution()
    result = solution.findWords(board, words)
    print(result)