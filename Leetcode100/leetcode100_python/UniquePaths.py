class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [0 for _ in range(m)]
        for i in range(n):
            for j in range(m):
                if i == 0 or j == 0:
                    dp[j] = 1
                else:
                    dp[j] = dp[j] + dp[j - 1]
        return dp[m - 1]

if __name__ == "__main__":
    m = int(input())
    n = int(input())
    solution = Solution()
    print(solution.uniquePaths(m, n))