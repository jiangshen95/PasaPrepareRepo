from typing import List

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        def bfs(row: int, col: int) -> None:
            queue = [(row, col)]
            grid[row][col] = '0'

            while queue:
                i, j = queue.pop(0)
                if i > 0 and grid[i - 1][j] == '1':
                    grid[i - 1][j] = '0'
                    queue.append((i - 1, j))
                if i < len(grid) - 1 and grid[i + 1][j] == '1':
                    grid[i + 1][j] = '0'
                    queue.append((i + 1, j))
                if j > 0 and grid[i][j - 1] == '1':
                    grid[i][j - 1] = '0'
                    queue.append((i, j - 1))
                if j < len(grid[0]) - 1 and grid[i][j + 1] == '1':
                    grid[i][j + 1] = '0'
                    queue.append((i, j + 1))

        if not grid:
            return 0
        m = len(grid)
        n = len(grid[0])
        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count += 1
                    bfs(i, j)
        return count


if __name__ == "__main__":
    n = int(input())
    grid = []
    for i in range(n):
        grid.append([num for num in input().split()])
    solution = Solution()
    print(solution.numIslands(grid))