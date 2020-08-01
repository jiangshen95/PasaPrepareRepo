from typing import List

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:

        class UnionFind:

            def __init__(self):
                self.count = 0
                m, n = len(grid), len(grid[0])
                self.parent = [0] * (m * n)
                for i in range(m):
                    for j in range(n):
                        if grid[i][j] == '1':
                            self.parent[i * n + j] = i * n + j
                            self.count += 1

            def find(self, x):
                while self.parent[x] != x:
                    self.parent[x] = self.parent[self.parent[x]]
                    x = self.parent[x]
                return x

            def union(self, x, y):
                parentx = self.find(x)
                parenty = self.find(y)
                if parentx != parenty:
                    self.parent[parentx] = parenty
                    self.count -= 1
            
            def getCount(self):
                return self.count

        if not grid:
            return 0
        m = len(grid)
        n = len(grid[0])
        uf = UnionFind()
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    grid[i][j] = '0'
                    if i > 0 and grid[i - 1][j] == '1':
                        uf.union(i * n + j, (i - 1) * n + j)
                    if i < len(grid) - 1 and grid[i + 1][j] == '1':
                        uf.union(i * n + j, (i + 1) * n + j)
                    if j > 0 and grid[i][j - 1] == '1':
                        uf.union(i * n + j, i * n + j - 1)
                    if j < len(grid[0]) - 1 and grid[i][j + 1] == '1':
                        uf.union(i * n + j, i * n + j + 1)
        return uf.getCount()


if __name__ == "__main__":
    n = int(input())
    grid = []
    for i in range(n):
        grid.append([num for num in input().split()])
    solution = Solution()
    print(solution.numIslands(grid))