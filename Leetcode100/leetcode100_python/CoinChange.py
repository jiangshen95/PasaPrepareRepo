from typing import List

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [-1] * (amount + 1)
        dp[0] = 0
        for coin in coins:
            for i in range(coin, amount + 1, 1):
                if dp[i - coin] != -1:
                    if dp[i] != -1:
                        dp[i] = min(dp[i], dp[i - coin] + 1)
                    else:
                        dp[i] = dp[i - coin] + 1
        return dp[-1]


if __name__ == "__main__":
    coins = [int(num) for num in input().split()]
    amount = int(input())
    solution = Solution()
    print(solution.coinChange(coins, amount))