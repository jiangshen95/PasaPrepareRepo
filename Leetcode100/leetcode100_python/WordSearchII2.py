from typing import List

class Solution:

    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:

        def backtrack(i: int , j: int, parent: map) -> None:
            t = board[i][j]
            cur = parent[t]
            if 'word' in cur:
                result.append(cur['word'])
                cur.pop('word')
            board[i][j] = '#'
            dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]
            for x, y in dirs:
                row = i + x
                col = j + y
                if row >= 0 and row < m and col >= 0 and col < n and \
                    board[row][col] in cur:
                    backtrack(row, col, cur)
            board[i][j] = t
            if not cur:
                parent.pop(t)


        trie = {}
        for word in words:
            cur = trie
            for c in word:
                if c not in cur:
                    cur[c] = {}
                cur = cur[c]
            cur['word'] = word

        result = []
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                if board[i][j] in trie:
                    backtrack(i, j, trie)
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