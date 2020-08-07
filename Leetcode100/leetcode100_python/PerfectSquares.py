class Solution:
    def numSquares(self, n: int) -> int:
        dp = [0] * (n + 1)
        for i in range(1, n + 1, 1):
            t = float('inf')
            j = 1
            while j * j <= i:
                t = min(t, dp[i - j * j])
                j += 1
            dp[i] = t + 1
        return dp[-1]

if __name__ == "__main__":
    n = int(input())
    solution = Solution()
    print(solution.numSquares(n))