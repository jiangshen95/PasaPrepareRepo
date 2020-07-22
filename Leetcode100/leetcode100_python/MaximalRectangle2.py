from typing import List

class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        m = len(matrix)
        n = len(matrix[0])
        max_rect = 0
        dp = [[0 for _ in range(n)] for __ in range(m)]
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '0':
                    dp[i][j] = 0
                else:
                    dp[i][j] = 1 if j == 0 else dp[i][j - 1] + 1
                
                min_len = 0x7fffffff
                for k in range(i, -1, -1):
                    min_len = min(min_len, dp[k][j])
                    max_rect = max(max_rect, min_len * (i - k + 1))

        return max_rect

if __name__ == "__main__":
    n = int(input())
    matrix = []
    for i in range(n):
        matrix.append([num for num in input().split()])
    solution = Solution()
    print(solution.maximalRectangle(matrix))