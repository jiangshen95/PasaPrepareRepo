from typing import List

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        def dfs(row: int, col: int) -> None:
            grid[row][col] = '0'
            if row > 0 and grid[row - 1][col] == '1':
                dfs(row - 1, col)
            if row < len(grid) - 1 and grid[row + 1][col] == '1':
                dfs(row + 1, col)
            if col > 0 and grid[row][col - 1] == '1':
                dfs(row, col - 1)
            if col < len(grid[0]) - 1 and grid[row][col + 1] == '1':
                dfs(row, col + 1)
        if not grid:
            return 0
        m = len(grid)
        n = len(grid[0])
        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count += 1
                    dfs(i, j)
        return count


if __name__ == "__main__":
    n = int(input())
    grid = []
    for i in range(n):
        grid.append([num for num in input().split()])
    solution = Solution()
    print(solution.numIslands(grid))