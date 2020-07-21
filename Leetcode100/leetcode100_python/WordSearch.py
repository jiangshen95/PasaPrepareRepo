from typing import List

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        def helper(row, col, index):
            if index == len(word) - 1:
                return word[index] == board[row][col]
            if word[index] == board[row][col]:
                visited[row][col] = True
                for i in range(4):
                    nrow = row + direction[i][0]
                    ncol = col + direction[i][1]
                    if 0 <= nrow < m and 0 <= ncol < n and not visited[nrow][ncol]:
                        if helper(nrow, ncol, index + 1):
                            return True
                visited[row][col] = False
            return False

        m = len(board)
        n = len(board[0])
        visited = [[False for _ in range(n)] for __ in range(m)]
        direction = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        for i in range(m):
            for j in range(n):
                if helper(i, j, 0):
                    return True
        return False
        

if __name__ == "__main__":
    n = int(input())
    board = []
    for i in range(n):
        board.append(input().split())
    word = input()
    solution = Solution()
    print(solution.exist(board, word))