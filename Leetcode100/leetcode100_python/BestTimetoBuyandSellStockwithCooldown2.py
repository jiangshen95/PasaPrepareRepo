from typing import List

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices:
            return 0
        n = len(prices)
        dp = [[0 for _ in range(3)] for __ in range(n)]
        for i in range(n):
            if i == 0:
                dp[i][0] = -prices[i]
            else:
                dp[i][0] = max(dp[i - 1][0], dp[i - 1][2] - prices[i])
                dp[i][1] = dp[i - 1][0] + prices[i]
                dp[i][2] = max(dp[i - 1][1], dp[i - 1][2])
        return max(dp[-1][1], dp[-1][2])


if __name__ == "__main__":
    prices = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.maxProfit(prices))