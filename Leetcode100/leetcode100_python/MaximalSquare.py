from typing import List

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        m = len(matrix)
        n = len(matrix[0])
        dp = [[0 for _ in range(n)] for __ in range(m)]
        
        result = 0
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '1':
                    if i == 0 or j == 0:
                        dp[i][j] = 1
                    else:
                        dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
                    result = max(result, dp[i][j])
        return result ** 2


if __name__ == "__main__":
    n = int(input())
    matrix = []
    for i in range(n):
        matrix.append([ch for ch in input().split()])
    solution = Solution()
    print(solution.maximalSquare(matrix))